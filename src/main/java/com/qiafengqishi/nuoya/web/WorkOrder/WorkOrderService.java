package com.qiafengqishi.nuoya.web.WorkOrder;

import com.qiafengqishi.nuoya.domain.WorkOrder;

public interface WorkOrderService {
    void store(WorkOrder workOderPO);

    WorkOrder findById(Long workOrderId);
}
