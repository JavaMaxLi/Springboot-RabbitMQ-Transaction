package com.lxf.rabbitmqorderservice.bean.UserOrderConfirm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author LiXiaoFeng
 * @date 2022年01月25日 14:41
 */
@Service
public class UserOrderConfirmServiceImpl implements UserOrderConfirmService{

    @Autowired
    UserOrderConfirmDao userOrderConfirmDao;

    @Override
    public List<UserOrderConfirmDBO> doSelectList(UserOrderConfirmDBO param) {
        return userOrderConfirmDao.doSelectList(param);
    }

    @Override
    public UserOrderConfirmDBO doRead(UserOrderConfirmDBO param) {
        return userOrderConfirmDao.doRead(param);
    }

    @Override
    public boolean doUpdate(UserOrderConfirmDBO param) {
        return userOrderConfirmDao.doUpdate(param);
    }

    @Override
    public boolean doDelete(UserOrderConfirmDBO param) {
        return userOrderConfirmDao.doDelete(param);
    }

    @Override
    public boolean doInsert(UserOrderConfirmDBO param) {
        return userOrderConfirmDao.doInsert(param);
    }
}
