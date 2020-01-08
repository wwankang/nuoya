package com.qiafengqishi.nuoya.domain;


import lombok.Data;

@Data
public class WorkCase {
    private Long workOrderId;

    /**
     * 取值：URGENT紧急 NORMAL一般
     */
    private String emergencyStatus;

    /**
     * 上报来源
     * 取值：临床Clinic 巡检RoutingInspection 领导指派SuperiorAssignment
     */
    private String reportedSource;


    private String reportedPersonName;

    private String reportedPersonPhone;

    private String reportedPersonRegion;

    private String reportedPersonBuilding;

    private String reportedPersonFloor;

    private String reportedPersonDepartment;

    private String reportedPersonDetailAddress;

    /**
     * 报修类型
     */
    private String reportedType;


    /**
     * 报修设备名称
     */
    private String reportedDeviceName;

    /**
     * 报修设备内容
     */
    private String reportedDeviceContents;

    /**
     * 报修设备区域
     */
    private String reportedDeviceRegion;

    /**
     * 报修设备楼宇
     */
    private String reportedDeviceBuilding;

    /**
     * 报修设备楼层
     */
    private String reportedDeviceFloor;

    /**
     * 报修设备房间
     */
    private String reportedDeviceRoom;

    /**
     * 报修设备详细地址
     */
    private String reportedDeviceDetailAddress;

    /**
     * 报修信息
     */
    private String applicantContents;

    /**
     * 申请时间
     */
    private String applyTime;

    /**
     * 期望时间
     */
    private String expectTime;

    /**
     * 工单处理状态
     */
    private String dealStatus;
}
