package com.lxf.rabbitmqorderservice.bean;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author LiXiaoFeng
 * @date 2022年01月24日 17:54
 */
public class ServiceOrderServiceImpl implements ServiceOrderService{

    @Autowired
    ServiceOrderDao serviceOrderDao;

    @Override
    public List<ServiceOrder> doSelectList(ServiceOrder param) {
        return serviceOrderDao.doSelectList(param);
    }

    @Override
    public ServiceOrder doRead(ServiceOrder param) {
        return serviceOrderDao.doRead(param);
    }

    @Override
    public boolean doUpdate(ServiceOrder param) {
        return serviceOrderDao.doUpdate(param);
    }

    @Override
    public boolean doDelete(ServiceOrder param) {
        return serviceOrderDao.doDelete(param);
    }

    @Override
    public boolean doInsert(ServiceOrder param) {
        return serviceOrderDao.doInsert(param);
    }
}
