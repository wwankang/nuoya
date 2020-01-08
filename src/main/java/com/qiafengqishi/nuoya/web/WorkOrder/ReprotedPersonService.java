package com.qiafengqishi.nuoya.web.WorkOrder;

import com.qiafengqishi.nuoya.domain.WorkOrder;
import com.qiafengqishi.nuoya.repository.dao.ReprotedPersonPO;

public interface ReprotedPersonService {
    void store(ReprotedPersonPO reprotedPersonPO);

    ReprotedPersonPO findById(Long reportedPersonId);
}
