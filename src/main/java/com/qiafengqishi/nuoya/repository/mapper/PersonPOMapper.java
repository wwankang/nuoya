package com.qiafengqishi.nuoya.repository.mapper;

import com.qiafengqishi.nuoya.repository.dao.PersonPO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PersonPOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PersonPO record);

    int insertSelective(PersonPO record);

    PersonPO selectByPrimaryKey(Long id);

    PersonPO selectByCode(String code);

    PersonPO selectByPhone(String phone);

    int updateByPrimaryKeySelective(PersonPO record);

    int updateByPrimaryKey(PersonPO record);
}