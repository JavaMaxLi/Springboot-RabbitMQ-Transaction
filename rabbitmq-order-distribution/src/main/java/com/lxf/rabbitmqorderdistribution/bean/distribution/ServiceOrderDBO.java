package com.lxf.rabbitmqorderdistribution.bean.distribution;

import com.lxf.rabbitmqorderdistribution.helper.DateHelper;
import com.lxf.rabbitmqorderdistribution.helper.EmptyHelper;

/**
 * @author LiXiaoFeng
 * @date 2022年01月24日 17:51
 */
public class ServiceOrderDBO {

    private int serviceId;

    private int orderId;

    private String msg;

    private String status;

    private String riderId;

    private String delFlag;

    private String createTime;

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRiderId() {
        return riderId;
    }

    public void setRiderId(String riderId) {
        this.riderId = riderId;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public void prepareInsert() {
        if (EmptyHelper.isEmpty(status)) {
            setStatus("0");
        }
        if (EmptyHelper.isEmpty(delFlag)) {
            setDelFlag("0");
        }
        if (EmptyHelper.isEmpty(createTime)) {
            setCreateTime(DateHelper.currentTimeMillisCN1());
        }
        if (EmptyHelper.isEmpty(riderId)) {
            setRiderId("11111111111");
        }
    }
}
