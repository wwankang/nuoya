package com.qiafengqishi.nuoya.repository.dao;

import lombok.Data;

import java.util.Date;

@Data
public class PersonPO {
    private Long id;

    private String code;

    private String name;

    private String phone;

    private String passWord;

    private String status;

    private String location;

    private Date addTime;

    private Date updateTime;

}