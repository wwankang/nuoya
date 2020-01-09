package com.qiafengqishi.nuoya.repository.dao;

import lombok.Data;

import java.util.Date;

@Data
public class Menus {
    private Long id;
    private String icon;
    private Long parentId;

    private String name;
    private String url;
    private Integer levels;
    private Integer ismenu;
    private Integer num;
    private String code;

    private Integer status;
    private String component;

    private Byte hidden;

}
