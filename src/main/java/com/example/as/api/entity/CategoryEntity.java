package com.example.as.api.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

//当返回的json某字段为null的时候，不显示
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategoryEntity {
    /**
     * 商品类别ID
     */
    public Integer categroyId;
    /**
     * 类别名
     */
    public String categroyName;
    /**
     * 创建时间
     */
    public String createTime;
}
