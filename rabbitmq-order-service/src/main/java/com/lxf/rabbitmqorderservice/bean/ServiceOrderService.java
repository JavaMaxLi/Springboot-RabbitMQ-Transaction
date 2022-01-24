package com.lxf.rabbitmqorderservice.bean;

import java.util.List;

/**
 * @author LiXiaoFeng
 * @date 2022年01月24日 17:53
 */
public interface ServiceOrderService {

    List<ServiceOrder> doSelectList(ServiceOrder param);

    ServiceOrder doRead(ServiceOrder param);

    boolean doUpdate(ServiceOrder param);

    boolean doDelete(ServiceOrder param);

    boolean doInsert(ServiceOrder param);
}
