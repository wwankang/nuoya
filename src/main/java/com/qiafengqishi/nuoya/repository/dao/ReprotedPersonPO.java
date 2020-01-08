package com.qiafengqishi.nuoya.repository.dao;

import lombok.Data;

import java.util.Date;

@Data
public class ReprotedPersonPO {
    private Long id;

    private String name;

    private String phone;

    private String region;

    private String building;

    private String floor;

    private String department;

    private String detailAddress;

    private String reportedType;

    private Date addTime;

    private Date updateTime;

}