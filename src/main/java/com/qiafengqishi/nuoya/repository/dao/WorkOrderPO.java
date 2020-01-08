package com.qiafengqishi.nuoya.repository.dao;

import lombok.Data;

import java.util.Date;


@Data
public class WorkOrderPO {
    private Long id;

    private String bizNo;

    private String emergencyStatus;

    private String reportedSource;

    private Long reportedPersonId;

    private Long reportedDeviceId;


    private Date applyTime;

    private Date expectTime;

    private String dealStatus;

    private Date addTime;

    private Date updateTime;




}