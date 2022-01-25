package com.lxf.rabbitmqorderservice.bean.order;

import com.alibaba.fastjson.JSONObject;
import com.lxf.rabbitmqorderservice.bean.UserOrderConfirm.UserOrderConfirmDBO;
import com.lxf.rabbitmqorderservice.bean.UserOrderConfirm.UserOrderConfirmDao;
import com.lxf.rabbitmqorderservice.bean.UserOrderConfirm.UserOrderConfirmService;
import com.lxf.rabbitmqorderservice.helper.DateHelper;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @author LiXiaoFeng
 * @date 2022年01月24日 17:53
 */
@Service
public class DistributionOrderServiceImpl implements DistributionOrderService{


    @Autowired
    RabbitTemplate rabbitTemplate;
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    DistributionOrderDao distributionOrderDao;
    @Autowired
    UserOrderConfirmService userOrderConfirmService;

    @Override
    public List<DistributionOrder> doSelectList(DistributionOrder param) {
        return distributionOrderDao.doSelectList(param);
    }

    @Override
    public DistributionOrder doRead(DistributionOrder param) {
        return distributionOrderDao.doRead(param);
    }

    @Override
    public boolean doUpdate(DistributionOrder param) {
        return distributionOrderDao.doUpdate(param);
    }

    @Override
    public boolean doDelete(DistributionOrder param) {
        return distributionOrderDao.doDelete(param);
    }

    @Override
    public boolean doInsert(DistributionOrder param) {
        boolean result = distributionOrderDao.doInsert(param);
        //消息队列发送冗余数据，防止消息发送失败数据丢失
        UserOrderConfirmDBO userOrderConfirmDBO = new UserOrderConfirmDBO();
        userOrderConfirmDBO.setOrderId(param.getOrderId());
        userOrderConfirmDBO.setRetry(0);
        userOrderConfirmDBO.setStatus("0");
        userOrderConfirmDBO.setDelFlag("0");
        userOrderConfirmDBO.setCreateTime(DateHelper.currentTimeMillisCN1());
        userOrderConfirmService.doInsert(userOrderConfirmDBO);
        return result;
    }

    /**
     * 通过PostConstruct在类实例化之后init之前设置rabbitmq的确认机制
     * 确认回调更新订单冗余表，更改消息发送状态，保证消息发送的可靠性
     */
    @PostConstruct
    public void serConfirmCallBack() {
        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            @Override
            public void confirm(CorrelationData correlationData, boolean ack, String cause) {
                String orderId = correlationData.getId();
                if (!ack) {
                    System.out.println("MQ消息发送失败");
                }
                //消息发送成功更新订单冗余表状态
                try {
                    UserOrderConfirmDBO userOrderConfirmDBO = new UserOrderConfirmDBO();
                    userOrderConfirmDBO.setOrderId(Integer.parseInt(orderId));
                    userOrderConfirmDBO = userOrderConfirmService.doRead(userOrderConfirmDBO);
                    userOrderConfirmDBO.setStatus("1");
                    userOrderConfirmService.doUpdate(userOrderConfirmDBO);
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * 发送消息
     * @param param
     */
    public void sendMessageRabbitMQ(DistributionOrder param) {
        rabbitTemplate.convertAndSend("dispatch_order_exchange","", JSONObject.toJSONString(param),new CorrelationData(String.valueOf(param.getOrderId())));
    }

    /**
     * RestTemplate发送消息
     * @param param
     * @return
     */
    @Override
    public String dispatchOrder(DistributionOrder param) {
        MultiValueMap<String, Object> request = new LinkedMultiValueMap<String, Object>();
        request.add("orderId",param.getOrderId());
        request.add("msg",param.getMsg());
        ResponseEntity<String> responseEntity = restTemplate.postForEntity("http://localhost:8010/putOrder", request, String.class);
        return responseEntity.getBody();
    }
}
