package com.qiafengqishi.nuoya.repository.dao;

import lombok.Data;

import java.util.Date;

@Data
public class MyUser {
    private Long id;

    private String name;

    private String code;

    private String phone;

    private String location;

    private Date addTime;

    private Date updateTime;

    private String status;

}