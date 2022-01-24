package com.lxf.rabbitmqorderdistribution.bean;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author LiXiaoFeng
 * @date 2022年01月24日 17:53
 */
public class DistributionOrderServiceImpl implements DistributionOrderService{

    @Autowired
    DistributionOrderDao distributionOrderDao;

    @Override
    public List<DistributionOrder> doSelectList(DistributionOrder param) {
        return distributionOrderDao.doSelectList(param);
    }

    @Override
    public DistributionOrder doRead(DistributionOrder param) {
        return distributionOrderDao.doRead(param);
    }

    @Override
    public boolean doUpdate(DistributionOrder param) {
        return distributionOrderDao.doUpdate(param);
    }

    @Override
    public boolean doDelete(DistributionOrder param) {
        return distributionOrderDao.doDelete(param);
    }

    @Override
    public boolean doInsert(DistributionOrder param) {
        return distributionOrderDao.doInsert(param);
    }
}
