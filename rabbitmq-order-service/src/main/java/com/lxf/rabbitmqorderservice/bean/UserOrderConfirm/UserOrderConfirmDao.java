package com.lxf.rabbitmqorderservice.bean.UserOrderConfirm;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/** 订单分派确认表*/
@Mapper
public interface UserOrderConfirmDao{

    List<UserOrderConfirmDBO> doSelectList(UserOrderConfirmDBO param);

    UserOrderConfirmDBO doRead(UserOrderConfirmDBO param);

    boolean doUpdate(UserOrderConfirmDBO param);

    boolean doDelete(UserOrderConfirmDBO param);

    boolean doInsert(UserOrderConfirmDBO param);
}
