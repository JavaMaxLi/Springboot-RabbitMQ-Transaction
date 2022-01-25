package com.lxf.rabbitmqorderdistribution.bean.distribution;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author LiXiaoFeng
 * @date 2022年01月24日 17:54
 */
@Service
public class ServiceOrderServiceImpl implements ServiceOrderService {

    @Autowired
    ServiceOrderDao serviceOrderDao;

    @Override
    public List<ServiceOrderDBO> doSelectList(ServiceOrderDBO param) {
        return serviceOrderDao.doSelectList(param);
    }

    @Override
    public ServiceOrderDBO doRead(ServiceOrderDBO param) {
        return serviceOrderDao.doRead(param);
    }

    @Override
    public boolean doUpdate(ServiceOrderDBO param) {
        return serviceOrderDao.doUpdate(param);
    }

    @Override
    public boolean doDelete(ServiceOrderDBO param) {
        return serviceOrderDao.doDelete(param);
    }

    @Override
    public boolean doInsert(ServiceOrderDBO param) {
        return serviceOrderDao.doInsert(param);
    }
}
