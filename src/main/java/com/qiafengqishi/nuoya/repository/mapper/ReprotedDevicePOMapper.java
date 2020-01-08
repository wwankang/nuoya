package com.qiafengqishi.nuoya.repository.mapper;

import com.qiafengqishi.nuoya.repository.dao.ReprotedDevicePO;

public interface ReprotedDevicePOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ReprotedDevicePO record);

    int insertSelective(ReprotedDevicePO record);

    ReprotedDevicePO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ReprotedDevicePO record);

    int updateByPrimaryKey(ReprotedDevicePO record);
}