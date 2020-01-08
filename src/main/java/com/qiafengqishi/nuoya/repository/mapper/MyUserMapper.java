package com.qiafengqishi.nuoya.repository.mapper;

import com.qiafengqishi.nuoya.repository.dao.MyUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MyUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MyUser record);

    int insertSelective(MyUser record);

    MyUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MyUser record);

    int updateByPrimaryKey(MyUser record);
}