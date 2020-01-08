package com.qiafengqishi.nuoya.repository.mapper;

import com.qiafengqishi.nuoya.repository.dao.ReprotedPersonPO;

public interface ReprotedPersonPOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ReprotedPersonPO record);

    int insertSelective(ReprotedPersonPO record);

    ReprotedPersonPO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ReprotedPersonPO record);

    int updateByPrimaryKey(ReprotedPersonPO record);
}