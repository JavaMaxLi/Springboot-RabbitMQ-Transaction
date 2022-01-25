package com.lxf.rabbitmqorderservice.controller;

import com.lxf.rabbitmqorderservice.bean.order.DistributionOrder;
import com.lxf.rabbitmqorderservice.bean.order.DistributionOrderService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author LiXiaoFeng
 * @date 2022年01月25日 10:03
 */
@RestController
public class OrderController {

    @Resource
    DistributionOrderService distributionOrderService;

    @GetMapping(value = "/getOrder")
    public DistributionOrder getOrder(DistributionOrder param) {
        return distributionOrderService.doRead(param);
    }

    /**
     * 用户下单需要进行派单配送
     * @param distributionOrder
     * @return
     */
    @PutMapping(value = "/putOrder")
    @Transactional(rollbackFor = {Exception.class})
    public String putOrder(DistributionOrder distributionOrder) throws Exception {
        distributionOrder.prepareInsert();
        boolean insert = distributionOrderService.doInsert(distributionOrder);
        String result = "下单成功，进行派单";
        if (insert) {
            result = distributionOrderService.dispatchOrder(distributionOrder);
        }
        if("fail".equals(result)) {
            System.out.println("订单派送失败");
            throw new Exception("订单派送失败");
        }
        return result;
    }

    /**
     * 用户下单需要进行派单配送
     * RabbitMQ派单
     * @param distributionOrder
     * @return
     */
    @PutMapping(value = "/putOrderRabbitMQ")
    public String putOrderRabbitMQ(DistributionOrder distributionOrder) throws Exception {
        distributionOrder.prepareInsert();
        //用户下单
        boolean insert = distributionOrderService.doInsert(distributionOrder);
        //rabbitmq订单冗余
        distributionOrderService.sendMessageRabbitMQ(distributionOrder);
        String result = "下单成功，进行派单";
        /*if (insert) {
            //配送平台派送
            result = distributionOrderService.dispatchOrder(distributionOrder);
        }*/
       /* if("fail".equals(result)) {
            System.out.println("订单派送失败");
            throw new Exception("订单派送失败");
        }*/
        return result;
    }
}
