package com.qiafengqishi.nuoya.repository.mapper;

import com.qiafengqishi.nuoya.repository.dao.Maintainer;

public interface MaintainerMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Maintainer record);

    int insertSelective(Maintainer record);

    Maintainer selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Maintainer record);

    int updateByPrimaryKey(Maintainer record);
}