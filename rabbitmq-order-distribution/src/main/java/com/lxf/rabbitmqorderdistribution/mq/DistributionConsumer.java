package com.lxf.rabbitmqorderdistribution.mq;

import com.alibaba.fastjson.JSONObject;
import com.lxf.rabbitmqorderdistribution.bean.distribution.ServiceOrderDBO;
import com.lxf.rabbitmqorderdistribution.bean.distribution.ServiceOrderService;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author LiXiaoFeng
 * @date 2022年01月25日 16:12
 */
@Component
public class DistributionConsumer {

    @Autowired
    ServiceOrderService serviceOrderService;

    int count = 0;

    /**
     * 监听 dispatch.fanout.queue 队列
     * @param message
     * @param channel
     * @param correlationData
     * @param tag
     */
    @RabbitListener(queues = {"dispatch.fanout.queue"})
    public void orderConsumer(String message, Channel channel, CorrelationData correlationData, @Header(AmqpHeaders.DELIVERY_TAG) long tag) throws IOException {
       try{
           System.out.println("收到的MQ消息："+message+"，count="+ ++count);
           JSONObject jsonObject = JSONObject.parseObject(message);
           System.out.println("jsonObject="+jsonObject);
           System.out.println(1/0);
           ServiceOrderDBO serviceOrderDBO = new ServiceOrderDBO();
           serviceOrderDBO.setOrderId(jsonObject.getInteger("orderId"));
           serviceOrderDBO.setMsg(jsonObject.getString("msg"));
           serviceOrderDBO.prepareInsert();
           serviceOrderService.doInsert(serviceOrderDBO);
           //手动ack告诉mq消息正常消费
           channel.basicAck(tag,false);
       }catch (Exception e) {
           //消费出现异常，防止死循环
           //param1 消息的tag
           //param2 是否多条处理
           //param3 是否重发
           //出现错误将消息传入死信队列
           channel.basicNack(tag,false,false);
       }
    }

    /**
     * 监听 dead.fanout.queue 死心队列
     * @param message
     * @param channel
     * @param correlationData
     * @param tag
     */
    @RabbitListener(queues = {"dead.fanout.queue"})
    public void deadQueue(String message, Channel channel, CorrelationData correlationData, @Header(AmqpHeaders.DELIVERY_TAG) long tag) throws IOException {
       try{
           System.out.println("收到的MQ消息："+message+"，count="+ ++count);
           JSONObject jsonObject = JSONObject.parseObject(message);
           System.out.println("jsonObject="+jsonObject);
           ServiceOrderDBO serviceOrderDBO = new ServiceOrderDBO();
           serviceOrderDBO.setOrderId(jsonObject.getInteger("orderId"));
           serviceOrderDBO.setMsg(jsonObject.getString("msg"));
           serviceOrderDBO.prepareInsert();
           serviceOrderService.doInsert(serviceOrderDBO);
           //手动ack告诉mq消息正常消费
           channel.basicAck(tag,false);
       }catch (Exception e) {
           System.out.println("死信队列出现错误，记录到mysql");
           //移除消息
           channel.basicNack(tag,false,false);
       }
    }
}
