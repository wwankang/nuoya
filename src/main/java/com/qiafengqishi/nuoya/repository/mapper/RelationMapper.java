package com.qiafengqishi.nuoya.repository.mapper;

import com.qiafengqishi.nuoya.repository.dao.Relation;
import com.qiafengqishi.nuoya.repository.dao.RelationExample;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.transaction.annotation.Transactional;

public interface RelationMapper {
    long countByExample(RelationExample example);

    int deleteByExample(RelationExample example);

    int insert(Relation record);

    int insertSelective(Relation record);

    List<Relation> selectByExample(RelationExample example);

    int updateByExampleSelective(@Param("record") Relation record, @Param("example") RelationExample example);

    int updateByExample(@Param("record") Relation record, @Param("example") RelationExample example);
    @Select("SELECT id, pId, NAME, ( CASE WHEN (pId = 0 OR pId IS NULL) THEN 'true' ELSE 'false' END ) OPEN FROM t_sys_role")
    List roleTreeList();

    @Select("SELECT r.id AS id, pId AS pId, NAME AS NAME, ( CASE WHEN (pId = 0 OR pId IS NULL) THEN 'true' ELSE 'false' END ) \"open\", ( CASE WHEN (r1.ID = 0 OR r1.ID IS NULL) THEN 'false' ELSE 'true' END ) AS checked FROM t_sys_role r LEFT JOIN ( SELECT ID FROM t_sys_role WHERE ID IN (#{ids})) r1 ON r.ID = r1.ID ORDER BY pId, num ASC")
    List roleTreeListByRoleId(Long[] ids);

    @Delete("delete from t_sys_relation where roleid=#{roleId}")
    int deleteByRoleId(Long roleId);
}