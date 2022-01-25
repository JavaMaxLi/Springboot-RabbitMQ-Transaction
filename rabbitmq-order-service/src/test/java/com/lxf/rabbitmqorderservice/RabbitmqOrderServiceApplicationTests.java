package com.lxf.rabbitmqorderservice;

import com.alibaba.fastjson.JSONObject;
import com.lxf.rabbitmqorderservice.bean.UserOrderConfirm.UserOrderConfirmDBO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RabbitmqOrderServiceApplicationTests {

    @Test
    void contextLoads() {
    }

    public static void main(String[] args) {
        UserOrderConfirmDBO a = new UserOrderConfirmDBO();
        a.setOrderId(1);
        a.setId(2);
        a.setStatus("0");
        a.setDelFlag("0");
        Object o = JSONObject.toJSON(a);
        System.out.println("JSONObject.toJSON(a):"+o);
        JSONObject jsonObject = JSONObject.parseObject(o.toString());
        System.out.println("jsonObject:"+jsonObject);
        System.out.println(jsonObject.get("id"));
        System.out.println(jsonObject.get("orderId"));
    }
}
