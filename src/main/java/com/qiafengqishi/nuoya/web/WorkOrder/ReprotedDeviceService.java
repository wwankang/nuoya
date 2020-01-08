package com.qiafengqishi.nuoya.web.WorkOrder;

import com.qiafengqishi.nuoya.domain.WorkOrder;
import com.qiafengqishi.nuoya.repository.dao.ReprotedDevicePO;

public interface ReprotedDeviceService {
    void store(ReprotedDevicePO reprotedDevicePO);

    ReprotedDevicePO findById(Long reportedDeviceId);
}
