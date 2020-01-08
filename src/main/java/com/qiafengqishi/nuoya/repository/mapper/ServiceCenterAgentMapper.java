package com.qiafengqishi.nuoya.repository.mapper;

import com.qiafengqishi.nuoya.repository.dao.ServiceCenterAgentPO;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface ServiceCenterAgentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ServiceCenterAgentPO record);

    int insertSelective(ServiceCenterAgentPO record);

    ServiceCenterAgentPO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ServiceCenterAgentPO record);

    int updateByPrimaryKey(ServiceCenterAgentPO record);
}