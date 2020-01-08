package com.qiafengqishi.nuoya.repository.dao;

import lombok.Data;

import java.util.Date;

@Data
public class Maintainer {
    private Long id;

    private Long personId;

    private String status;

    private String maintainGroupCode;

    private Date addTime;

    private Date updateTime;


}