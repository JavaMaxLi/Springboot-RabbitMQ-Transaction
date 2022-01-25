package com.lxf.rabbitmqorderdistribution.bean.distribution;

import java.util.List;

/**
 * @author LiXiaoFeng
 * @date 2022年01月24日 17:53
 */
public interface ServiceOrderService {

    List<ServiceOrderDBO> doSelectList(ServiceOrderDBO param);

    ServiceOrderDBO doRead(ServiceOrderDBO param);

    boolean doUpdate(ServiceOrderDBO param);

    boolean doDelete(ServiceOrderDBO param);

    boolean doInsert(ServiceOrderDBO param);
}
