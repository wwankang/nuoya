package com.qiafengqishi.nuoya.repository.dao;

import lombok.Data;

import java.util.Date;


@Data
public class ServiceCenterAgentPO {
    private Long id;

    private Long personId;

    private Date addTime;

    private Date updateTime;

}