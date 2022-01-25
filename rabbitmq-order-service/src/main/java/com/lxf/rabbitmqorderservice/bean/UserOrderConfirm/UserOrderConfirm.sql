CREATE TABLE user_order_confirm
(
    id VARCHAR(20) NOT NULL AUTO_INCREMENT COMMENT '流水ID',
    order_id VARCHAR(20) COMMENT '订单ID',
    status VARCHAR(20) COMMENT '状态',
    retry VARCHAR(20) COMMENT '重发次数',
    del_flag CHAR(1) DEFAULT '0' COMMENT '有效标识',
    create_time VARCHAR(24) DEFAULT '2022-01-20 09:00:12' NOT NULL COMMENT '创建时间',
PRIMARY KEY (id)
) COMMENT '订单分派确认表'
;
