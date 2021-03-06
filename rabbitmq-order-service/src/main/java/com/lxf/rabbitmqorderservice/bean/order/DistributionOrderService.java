package com.lxf.rabbitmqorderservice.bean.order;


import java.util.List;

/**
 * @author LiXiaoFeng
 * @date 2022年01月24日 17:53
 */

public interface DistributionOrderService {

    List<DistributionOrder> doSelectList(DistributionOrder param);

    DistributionOrder doRead(DistributionOrder param);

    boolean doUpdate(DistributionOrder param);

    boolean doDelete(DistributionOrder param);

    boolean doInsert(DistributionOrder param);

    String dispatchOrder(DistributionOrder param);

    void sendMessageRabbitMQ(DistributionOrder param);
}
