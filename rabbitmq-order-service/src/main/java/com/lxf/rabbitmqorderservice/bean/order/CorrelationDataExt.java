package com.lxf.rabbitmqorderservice.bean.order;

import org.springframework.amqp.core.ReturnedMessage;
import org.springframework.amqp.rabbit.connection.CorrelationData;

/**
 * @author LiXiaoFeng
 * @date 2022年01月25日 15:49
 */
public class CorrelationDataExt extends CorrelationData {
    private volatile String id;

    private volatile Object data;

    public CorrelationDataExt(String id) {
        super(id);
        this.id = id;
    }



    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
