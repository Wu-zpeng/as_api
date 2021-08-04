package com.example.as.api.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

//该注解当返回的json某字段为null的时候，不显示
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserEntity {
    /**
     * 用户ID
     */
    public String uid;
    /**
     * Imooc用户ID
     */
    public String imoocId;
    /**
     * 订单ID
     */
    public String orderId;
    /**
     * 用户名
     */
    public String userName;
    /**
     * 密码
     */
    public String pwd;
    /**
     * 创建时间
     */
    public String creatTime;
    /**
     * 是否被禁用
     */
    public String forbid;
}
