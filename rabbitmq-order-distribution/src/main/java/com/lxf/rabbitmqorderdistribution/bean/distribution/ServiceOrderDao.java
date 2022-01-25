package com.lxf.rabbitmqorderdistribution.bean.distribution;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author LiXiaoFeng
 * @date 2022年01月24日 17:53
 */
@Mapper
public interface ServiceOrderDao {

    List<ServiceOrderDBO> doSelectList(ServiceOrderDBO param);

    ServiceOrderDBO doRead(ServiceOrderDBO param);

    boolean doUpdate(ServiceOrderDBO param);

    boolean doDelete(ServiceOrderDBO param);

    boolean doInsert(ServiceOrderDBO param);
}
