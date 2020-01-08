package com.qiafengqishi.nuoya.repository.mapper;

import com.qiafengqishi.nuoya.domain.RoleTree;
import com.qiafengqishi.nuoya.domain.node.ZTreeNode;
import com.qiafengqishi.nuoya.repository.dao.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    @Select("SELECT * FROM t_sys_role")
    List<Role> findAll();

    @Select("SELECT id, pId, NAME, ( CASE WHEN (pId = 0 OR pId IS NULL) THEN 'true' ELSE 'false' END ) OPEN FROM t_sys_role")
    List roleTreeList();

    @Select({
            "<script>",
            "SELECT " +
            "r.id AS id, " +
            "pId AS pId, " +
            "NAME AS name, " +
            "( CASE WHEN (pId = 0 OR pId IS NULL) THEN 'true' ELSE 'false' END ) 'open', " +
            "( CASE WHEN (r1.ID = 0 OR r1.ID IS NULL) THEN 'false' ELSE 'true' END ) AS checked " +
            "FROM t_sys_role r " +
            "LEFT JOIN ( SELECT ID FROM t_sys_role WHERE ID IN",
            "<foreach collection='array' item='item' open='(' separator=',' close=')'>",
            "#{item}",
            "</foreach>"+
                    ") r1 " +
            "ON r.ID = r1.ID " +
            "ORDER BY pId, num " +
            "ASC",
            "</script>",
    })
    List<ZTreeNode> roleTreeListByRoleId(Long[] ids);

    @Select("SELECT * FROM t_sys_role WHERE name like #{name} ")
    List<Role> findByName(String name);
}