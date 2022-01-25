package com.lxf.rabbitmqorderservice.bean.UserOrderConfirm;

import java.sql.Date;
 
/** 订单分派确认表*/
public class UserOrderConfirmDBO
{

    private int id;


    /** 
     * 订单ID
     */
    private int orderId;


    /** 
     * 状态
     */
    private String status = null;
 
    /** 
     * 重发次数
     */
    private int retry;


    private String delFlag = null;


    private String createTime = null;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getRetry() {
        return retry;
    }

    public void setRetry(int retry) {
        this.retry = retry;
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
}
