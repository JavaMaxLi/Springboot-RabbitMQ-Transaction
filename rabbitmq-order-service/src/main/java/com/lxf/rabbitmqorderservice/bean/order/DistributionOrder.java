package com.lxf.rabbitmqorderservice.bean.order;

import com.lxf.rabbitmqorderservice.helper.DateHelper;
import com.lxf.rabbitmqorderservice.helper.EmptyHelper;

import java.io.Serializable;

/**
 * @author LiXiaoFeng
 * @date 2022年01月25日 10:10
 */
public class DistributionOrder implements Serializable {
    private int orderId;

    private String msg;

    private String userId;

    private String delFlag;

    private String createTime;

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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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
        if (EmptyHelper.isEmpty(createTime)) {
            setCreateTime(DateHelper.currentTimeMillisCN1());
        }
        if (EmptyHelper.isEmpty(delFlag)) {
            setDelFlag("0");
        }
    }

    @Override
    public String toString() {
        return "DistributionOrder{" +
                "orderId=" + orderId +
                ", msg='" + msg + '\'' +
                ", userId='" + userId + '\'' +
                ", delFlag='" + delFlag + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
