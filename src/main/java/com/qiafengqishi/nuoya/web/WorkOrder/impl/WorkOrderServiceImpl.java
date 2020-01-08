package com.qiafengqishi.nuoya.web.WorkOrder.impl;

import com.qiafengqishi.nuoya.domain.WorkOrder;
import com.qiafengqishi.nuoya.repository.dao.WorkOrderPO;
import com.qiafengqishi.nuoya.repository.mapper.WorkOrderPOMapper;
import com.qiafengqishi.nuoya.server.DateUtils;
import com.qiafengqishi.nuoya.web.WorkOrder.WorkOrderService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;



@Component
public class WorkOrderServiceImpl implements WorkOrderService {
    @Resource
    private WorkOrderPOMapper workOrderPOMapper;

    @Override
    public void store(WorkOrder workOder) {
        WorkOrderPO workOrderPO = toPO(workOder);
        workOrderPOMapper.insert(workOrderPO);
        
        workOder.setId(workOrderPO.getId());
    }

    @Override
    public WorkOrder findById(Long workOrderId) {
        WorkOrderPO po = workOrderPOMapper.selectByPrimaryKey(workOrderId);
        return toDO(po);
    }

    private WorkOrder toDO(WorkOrderPO workOderPO) {
        if (null == workOderPO) {
            return null;
        }
        WorkOrder workOrder = new WorkOrder();
        workOrder.setEmergencyStatus(WorkOrder.EmergencyStatus.valueOf(workOderPO.getEmergencyStatus()));
        workOrder.setApplyTime(workOderPO.getApplyTime());
        workOrder.setBizNo(workOderPO.getBizNo());
        workOrder.setDealStatus(WorkOrder.DealStatus.valueOf(workOderPO.getDealStatus()));
        workOrder.setExpectTime(workOderPO.getExpectTime());

        workOrder.setReportedDeviceId(workOderPO.getReportedDeviceId());
        workOrder.setReportedPersonId(workOderPO.getReportedPersonId());
        workOrder.setReportedSource(WorkOrder.ReportedSource.valueOf(workOderPO.getReportedSource()));


        return workOrder;
    }


    private WorkOrderPO toPO(WorkOrder workOder) {
        WorkOrderPO po = new WorkOrderPO();
        po.setEmergencyStatus(workOder.getEmergencyStatus().name());
        po.setApplyTime(workOder.getApplyTime());
        po.setBizNo(workOder.getBizNo());
        po.setDealStatus(workOder.getDealStatus().name());
        po.setExpectTime(workOder.getExpectTime());

        po.setReportedDeviceId(workOder.getReportedDeviceId());
        po.setReportedPersonId(workOder.getReportedPersonId());
        po.setReportedSource(workOder.getReportedSource().name());

        po.setUpdateTime(DateUtils.now());
        po.setAddTime(DateUtils.now());

        return po;
    }
}
