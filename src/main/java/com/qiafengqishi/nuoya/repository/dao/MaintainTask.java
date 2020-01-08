package com.qiafengqishi.nuoya.repository.dao;

import lombok.Data;

import java.util.Date;


@Data
public class MaintainTask {
    private Long id;

    private Long workOrderId;

    private String maintainerCode;

    private String maintainGroupCode;

    private String status;

    private Date beginTime;

    private Date endTime;

    private String contents;

    private Date addTime;

    private Date updateTime;

}