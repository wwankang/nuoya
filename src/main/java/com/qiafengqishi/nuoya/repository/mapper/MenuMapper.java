package com.qiafengqishi.nuoya.repository.mapper;

import com.qiafengqishi.nuoya.repository.dao.Menu;
import com.qiafengqishi.nuoya.repository.dao.Menus;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MenuMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);

    List<Menus> getMenusByRoleids(Long [] roleids);

    @Delete("delete from t_sys_relation where menuid=#{menuId}")
    void deleteRelationByMenu(Long menuId);

    @Select("SELECT * from t_sys_relation where pcode like #{s}")
    List<Menu> findByPcodesLike(String s);

    @Select("SELECT m1.id AS id, m1.icon AS icon, ( CASE WHEN (m2.id = 0 OR m2.id IS NULL) " +
            "THEN 0 ELSE m2.id END ) AS parentId, m1. NAME AS NAME, m1.url AS url, m1.levels AS levels, m1.ismenu AS " +
            "ismenu, m1.num AS num, m1. CODE AS CODE,m1.status as status,m1.component,m1.hidden FROM t_sys_menu m1 LEFT JOIN t_sys_menu m2 " +
            "ON " +
            "m1.pcode = m2. CODE ORDER BY levels, num ASC")
    List getMenus();


    @Select("SELECT m1.id AS id, ( CASE WHEN (m2.id = 0 OR m2.id IS NULL) THEN 0 ELSE m2.id END ) AS pId, m1. NAME AS NAME, ( CASE WHEN (m2.id = 0 OR m2.id IS NULL) THEN 'true' ELSE 'false' END ) AS isOpen FROM t_sys_menu m1 LEFT JOIN t_sys_menu m2 ON m1.pcode = m2. CODE ORDER BY m1.id ASC")
    List menuTreeList();

    @Select("SELECT m1.id AS id, ( CASE WHEN (m2.id = 0 OR m2.id IS NULL) THEN 0 ELSE m2.id END ) AS pId, m1. NAME AS NAME, ( CASE WHEN (m2.id = 0 OR m2.id IS NULL) THEN 'true' ELSE 'false' END ) AS isOpen, ( CASE WHEN (m3.ID = 0 OR m3.ID IS NULL) THEN 'false' ELSE 'true' END ) \"checked\" FROM t_sys_menu m1 LEFT JOIN t_sys_menu m2 ON m1.pcode = m2. CODE LEFT JOIN ( SELECT ID FROM t_sys_menu WHERE ID IN (#{menuIds})) m3 ON m1.id = m3.id ORDER BY m1.id ASC")
    List menuTreeListByMenuIds(List<Long> menuIds);

    @Select("SELECT * from t_sys_relation where pcode=#{pcode}")
    Menu findByCode(String pcode);

    @Select("select menuid from t_sys_relation where roleid=#{roleId}")
    List getMenuIdsByRoleId(Integer roleId);

    @Select("select url from t_sys_relation rel inner join t_sys_menu m on rel.menuid = m.id where m.status=1 and  rel.roleid=#{roleId}")
    List<String> getResUrlsByRoleId(Long roleId);
}