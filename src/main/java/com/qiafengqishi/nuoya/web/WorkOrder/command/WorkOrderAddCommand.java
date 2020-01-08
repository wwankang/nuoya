package com.qiafengqishi.nuoya.web.WorkOrder.command;


import lombok.Data;

import java.util.Date;

@Data
public class WorkOrderAddCommand {

    /**
     * 紧急程度
     * 取值：URGENT紧急 NORMAL一般
     */
    private String emergencyStatus;

    /**
     * 报修来源
     * 取值：临床Clinic 巡检RoutingInspection 领导指派SuperiorAssignment
     */
    private String reportedSource;

    /**
     * 报修人
     * 要求：必传
     */
    private String reportedPersonName;

    /**
     * 报修电话
     * 要求：必传
     */
    private String reportedPersonPhone;

    /**
     * 报修人区域
     */
    private String reportedPersonRegion;

    /**
     * 报修人楼宇
     */
    private String reportedPersonBuilding;

    /**
     * 报修人楼层
     */
    private String reportedPersonFloor;

    /**
     * 报修人科室
     */
    private String reportedPersonDepartment;

    /**
     * 报修人详细地址
     */
    private String reportedPersonDetailAddress;

    /**
     * 报修类型
     */
    private String reportedType;


    /**
     * 报修设备名称
     * 要求：必传
     */
    private String reportedDeviceName;

    /**
     * 期望时间
     */
    private String expectTime;

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
     * 申请时间
     */
    private String applyTime;

    /**
     * 工单处理状态
     * 取值： //未派工 TO_ASSIGN, //待维修 TO_MAINTAIN, //处理中 PROCESSING,//暂停 BLOCKED,//撤销 REVOKE,//完成 PROCESSED,
     */
    private String dealStatus;

    public boolean isValid() {
        if (null == this) {
            return false;
        }
        return true;
    }

}
