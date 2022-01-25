package com.lxf.rabbitmqorderservice.bean.order;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author LiXiaoFeng
 * @date 2022年01月24日 17:53
 */
@Mapper
public interface DistributionOrderDao {

    List<DistributionOrder> doSelectList(DistributionOrder param);

    DistributionOrder doRead(DistributionOrder param);

    boolean doUpdate(DistributionOrder param);

    boolean doDelete(DistributionOrder param);

    boolean doInsert(DistributionOrder param);
}
