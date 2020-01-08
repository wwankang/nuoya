package com.qiafengqishi.nuoya.repository.mapper;

import com.qiafengqishi.nuoya.repository.dao.MaintainTask;

public interface MaintainTaskMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MaintainTask record);

    int insertSelective(MaintainTask record);

    MaintainTask selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MaintainTask record);

    int updateByPrimaryKey(MaintainTask record);
}