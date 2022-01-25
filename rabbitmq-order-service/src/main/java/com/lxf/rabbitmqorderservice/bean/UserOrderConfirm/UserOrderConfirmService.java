package com.lxf.rabbitmqorderservice.bean.UserOrderConfirm;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/** 订单分派确认表*/
public interface UserOrderConfirmService{

    List<UserOrderConfirmDBO> doSelectList(UserOrderConfirmDBO param);

    UserOrderConfirmDBO doRead(UserOrderConfirmDBO param);

    boolean doUpdate(UserOrderConfirmDBO param);

    boolean doDelete(UserOrderConfirmDBO param);

    boolean doInsert(UserOrderConfirmDBO param);

}
