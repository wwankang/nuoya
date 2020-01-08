package com.qiafengqishi.nuoya.repository.dao;

import lombok.Data;

import java.util.Date;

@Data
public class ReprotedDevicePO {
    private Long id;

    private String name;

    private String reportedType;

    private String contents;

    private String region;

    private String building;

    private String floor;

    private String room;

    private String detailAddress;

    private Date addTime;

    private Date updateTime;

}