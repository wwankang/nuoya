package com.qiafengqishi.nuoya.domain;

import lombok.Data;

import java.util.Date;

@Data
public class WorkOrder {
    private Long id;

    private String bizNo;

    private EmergencyStatus emergencyStatus;

    private ReportedSource reportedSource;

    private Long reportedPersonId;



    private Long reportedDeviceId;



    private Date applyTime;

    private Date expectTime;

    private DealStatus dealStatus;

    public enum DealStatus {
        //未派工
        TO_ASSIGN,
        //待维修
        TO_MAINTAIN,
        //处理中
        PROCESSING,
        //暂停
        BLOCKED,
        //撤销
        REVOKE,
        //完成
        PROCESSED,
        ;
    }


    public enum EmergencyStatus{
        //紧急
        URGENT,

        //一般
        NORMAL,
        ;
    }

    public enum ReportedSource {
        //临床
        Clinic,
        //巡检
        RoutingInspection,
        //领导指派
        SuperiorAssignment,
        ;
    }
}
