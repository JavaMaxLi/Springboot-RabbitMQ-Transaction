package com.lxf.rabbitmqorderdistribution.controller;

import com.lxf.rabbitmqorderdistribution.bean.distribution.ServiceOrderDBO;
import com.lxf.rabbitmqorderdistribution.bean.distribution.ServiceOrderService;
import com.lxf.rabbitmqorderdistribution.helper.EmptyHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

/**
 * @author LiXiaoFeng
 * @date 2022年01月25日 09:36
 */
@RestController
public class DistributionController {

    @Autowired
    ServiceOrderService serviceOrderService;

    @GetMapping(value = "/getOrder")
    public ServiceOrderDBO getOrder(ServiceOrderDBO serviceOrderDBO) {
        return serviceOrderService.doRead(serviceOrderDBO);
    }

    @PostMapping(value = "/putOrder")
    @Transactional
    public String putOrder(ServiceOrderDBO serviceOrderDBO) throws Exception {
        if ("购买骨头饭".equals(serviceOrderDBO.getMsg())) {
            throw new Exception("派单出现异常");
        }
        if (EmptyHelper.isEmpty(serviceOrderDBO.getOrderId())) {
            return "1001";
        }
        serviceOrderDBO.prepareInsert();
        if (serviceOrderDBO.getOrderId() == 10) {
            throw new NullPointerException();
        }
        boolean insert = serviceOrderService.doInsert(serviceOrderDBO);
        if (!insert) {
            return "1002";
        }
        return String.valueOf(serviceOrderDBO.getServiceId());
    }
}
