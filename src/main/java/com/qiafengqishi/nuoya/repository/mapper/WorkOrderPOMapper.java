package com.qiafengqishi.nuoya.repository.mapper;

import com.qiafengqishi.nuoya.repository.dao.WorkOrderPO;

public interface WorkOrderPOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(WorkOrderPO record);

    int insertSelective(WorkOrderPO record);

    WorkOrderPO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(WorkOrderPO record);

    int updateByPrimaryKey(WorkOrderPO record);
}