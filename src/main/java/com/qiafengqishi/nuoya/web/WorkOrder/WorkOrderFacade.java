package com.qiafengqishi.nuoya.web.WorkOrder;

import com.qiafengqishi.nuoya.domain.WorkCase;
import com.qiafengqishi.nuoya.domain.WorkOrder;

import com.qiafengqishi.nuoya.repository.dao.ReprotedDevicePO;
import com.qiafengqishi.nuoya.repository.dao.ReprotedPersonPO;
import com.qiafengqishi.nuoya.server.DateUtils;
import com.qiafengqishi.nuoya.web.WorkOrder.command.WorkOrderAddCommand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.beans.Transient;



@Component
public class WorkOrderFacade {
    @Autowired
    private ReprotedDeviceService reprotedDeviceService;
    @Autowired
    private ReprotedPersonService reprotedPersonService;
    @Autowired
    private WorkOrderService workOrderService;

    @Transient
    public void newWorkOrder(WorkOrderAddCommand registerCommand) {

        ReprotedDevicePO reprotedDevicePO = toReportDevice(registerCommand);
        reprotedDeviceService.store(reprotedDevicePO);
        ReprotedPersonPO reprotedPersonPO = toReportPerson(registerCommand);
        reprotedPersonService.store(reprotedPersonPO);

        WorkOrder workOderPO =  toWorkOrder(registerCommand);
        workOderPO.setReportedPersonId(reprotedPersonPO.getId());
        workOderPO.setReportedDeviceId(reprotedDevicePO.getId());
        workOrderService.store(workOderPO);

    }


    public WorkCase getById(Long workOrderId) {
        WorkOrder workOrder = workOrderService.findById(workOrderId);
        if (null == workOrder) {
            return null;
        }

        ReprotedDevicePO reprotedDevicePO = reprotedDeviceService.findById(workOrder.getReportedDeviceId());
        ReprotedPersonPO personPO = reprotedPersonService.findById(workOrder.getReportedPersonId());


        //组合
        WorkCase workCase = toWorkCase(workOrder, reprotedDevicePO, personPO);
        return workCase;
    }

    private WorkCase toWorkCase(WorkOrder workOrder, ReprotedDevicePO reprotedDevicePO, ReprotedPersonPO personPO) {
        WorkCase workCase = new WorkCase();
        workCase.setWorkOrderId(workOrder.getId());
        workCase.setEmergencyStatus(workOrder.getEmergencyStatus() + "");
        workCase.setReportedSource(workOrder.getReportedSource() + "");
//        workCase.setApplicantContents();//fixme
        workCase.setApplyTime(DateUtils.toString(workOrder.getApplyTime()));
        workCase.setExpectTime(DateUtils.toString(workOrder.getExpectTime()));
        workCase.setDealStatus(workOrder.getDealStatus() + "");

        if (null != personPO) {
            workCase.setReportedPersonName(personPO.getName());
            workCase.setReportedPersonPhone(personPO.getPhone());
            workCase.setReportedPersonRegion(personPO.getRegion());
            workCase.setReportedPersonBuilding(personPO.getBuilding());
            workCase.setReportedPersonFloor(personPO.getFloor());
            workCase.setReportedPersonDepartment(personPO.getDepartment());
            workCase.setReportedPersonDetailAddress(personPO.getDetailAddress());
        }

//        workCase.setReportedType();

        if (null != reprotedDevicePO) {
            workCase.setReportedDeviceName(reprotedDevicePO.getName());
            workCase.setReportedType(reprotedDevicePO.getReportedType());
            workCase.setReportedDeviceContents(reprotedDevicePO.getContents());
            workCase.setReportedDeviceRegion(reprotedDevicePO.getRegion());
            workCase.setReportedDeviceBuilding(reprotedDevicePO.getBuilding());
            workCase.setReportedDeviceFloor(reprotedDevicePO.getFloor());
            workCase.setReportedDeviceRoom(reprotedDevicePO.getRoom());
            workCase.setReportedDeviceDetailAddress(reprotedDevicePO.getDetailAddress());
        }

        return workCase;
    }


    private ReprotedPersonPO toReportPerson(WorkOrderAddCommand registerCommand) {
        ReprotedPersonPO reprotedPersonPO = new ReprotedPersonPO();
//        reprotedPersonPO.setId();
        reprotedPersonPO.setName(registerCommand.getReportedPersonName());
        reprotedPersonPO.setPhone(registerCommand.getReportedPersonPhone());
        reprotedPersonPO.setRegion(registerCommand.getReportedPersonRegion());
        reprotedPersonPO.setBuilding(registerCommand.getReportedPersonBuilding());
        reprotedPersonPO.setFloor(registerCommand.getReportedPersonFloor());
        reprotedPersonPO.setDepartment(registerCommand.getReportedPersonDepartment());
        reprotedPersonPO.setDetailAddress(registerCommand.getReportedPersonDetailAddress());

        return reprotedPersonPO;

    }

    private ReprotedDevicePO toReportDevice(WorkOrderAddCommand registerCommand) {
        ReprotedDevicePO reprotedDevicePO = new ReprotedDevicePO();
//        reprotedDevicePO.setId();
        reprotedDevicePO.setName(registerCommand.getReportedDeviceName());
        reprotedDevicePO.setRegion(registerCommand.getReportedDeviceRegion());
        reprotedDevicePO.setBuilding(registerCommand.getReportedDeviceBuilding());
        reprotedDevicePO.setFloor(registerCommand.getReportedDeviceFloor());
        reprotedDevicePO.setRoom(registerCommand.getReportedDeviceRoom());
        reprotedDevicePO.setDetailAddress(registerCommand.getReportedDeviceDetailAddress());
        reprotedDevicePO.setReportedType(registerCommand.getReportedType());
        reprotedDevicePO.setContents(registerCommand.getReportedDeviceContents());

        return reprotedDevicePO;
    }

    private WorkOrder toWorkOrder(WorkOrderAddCommand registerCommand) {
        WorkOrder workOrder = new WorkOrder();
        workOrder.setEmergencyStatus(WorkOrder.EmergencyStatus.valueOf(registerCommand.getEmergencyStatus()));
        workOrder.setApplyTime(DateUtils.now());
//        workOrder.setBizNo();  //取ID？+ 时间？
        workOrder.setDealStatus(WorkOrder.DealStatus.TO_ASSIGN);

        if (null != registerCommand.getExpectTime()) {
            workOrder.setExpectTime(DateUtils.asDate(registerCommand.getExpectTime()));
        }
//        workOrder.setReportedDeviceId(); //fixme 先存，才有这个id
//        workOrder.setReportedPersonId(); //fixme 先存，才有这个id
        workOrder.setReportedSource(WorkOrder.ReportedSource.valueOf(registerCommand.getReportedSource()));


        return workOrder;
    }


}
