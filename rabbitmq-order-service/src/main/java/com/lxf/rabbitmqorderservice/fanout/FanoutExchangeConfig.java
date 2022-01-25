package com.lxf.rabbitmqorderservice.fanout;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LiXiaoFeng
 * @date 2022年01月25日 17:02
 */
@Configuration
public class FanoutExchangeConfig {
    
    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange("dispatch_order_exchange");
    }

    @Bean
    public Queue queue() {
        Map<String,Object> args = new HashMap<>();
        args.put("x-dead-letter-exchange","dead_order_exchange");//死信队列交换机
        return new Queue("dispatch.fanout.queue",true,false,false,args);
    }

    @Bean
    public Binding binding () {
        return BindingBuilder.bind(queue()).to(fanoutExchange());
    }



    @Bean
    public FanoutExchange deadFanoutExchange() {
        return new FanoutExchange("dead_order_exchange");
    }

    @Bean
    public Queue deadQueue() {
        return new Queue("dead.fanout.queue");
    }


    @Bean
    public Binding deadBinding() {
        return BindingBuilder.bind(deadQueue()).to(deadFanoutExchange());
    }
}
