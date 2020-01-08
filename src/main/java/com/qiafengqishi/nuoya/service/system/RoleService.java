package com.qiafengqishi.nuoya.service.system;


import com.qiafengqishi.nuoya.domain.RoleTree;
import com.qiafengqishi.nuoya.domain.node.Node;
import com.qiafengqishi.nuoya.domain.node.ZTreeNode;
import com.qiafengqishi.nuoya.repository.dao.Relation;
import com.qiafengqishi.nuoya.repository.dao.RelationExample;
import com.qiafengqishi.nuoya.repository.dao.Role;
import com.qiafengqishi.nuoya.repository.mapper.RelationMapper;
import com.qiafengqishi.nuoya.repository.mapper.RoleMapper;
import com.qiafengqishi.nuoya.utils.Convert;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created  on 2018/3/25 0025.
 *
 * @author enilu
 */
@Service
public class RoleService {
    @Resource
    private RoleMapper roleMapper;
    @Resource
    private RelationMapper relationMapper;

    public List<ZTreeNode> roleTreeList() {
        List list = roleMapper.roleTreeList();
        List<ZTreeNode> treeNodes = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Object[] arr = (Object[]) list.get(i);
            ZTreeNode node = new ZTreeNode();
            node.setId(Long.valueOf(arr[0].toString()));
            node.setpId(Long.valueOf(arr[1].toString()));
            node.setName(arr[2].toString());
            node.setOpen(Boolean.valueOf(arr[3].toString()));
            treeNodes.add(node);
        }
        return treeNodes;
    }


    public List<ZTreeNode> roleTreeListByRoleId(Long[] ids) {
        List<ZTreeNode> list = roleMapper.roleTreeListByRoleId(ids);
        System.out.println(list);
        return list;
    }


    public void setAuthority(Long roleId, String ids) {
        // 删除该角色所有的权限
        RelationExample relationExample = new RelationExample();
        relationExample.createCriteria().andRoleidEqualTo(roleId);
        relationMapper.deleteByExample(relationExample);

        // 添加新的权限
        for (Long id : Convert.toLongArray(true, Convert.toStrArray(",", ids))) {
            Relation relation = new Relation();
            relation.setRoleid(roleId);
            relation.setMenuid(id);
            relationMapper.insert(relation);
        }
    }

    public void delRoleById(Long roleId) {
        //删除角色
        roleMapper.deleteByPrimaryKey(roleId);

        // 删除该角色所有的权限
        relationMapper.deleteByRoleId(roleId);
    }


    public List<Node> generateRoleTree(List<ZTreeNode> list) {
        List<Node> nodes = new ArrayList<>();
        for (ZTreeNode role : list) {
            Node roleNode = new Node();
            roleNode.setId(role.getId());
            roleNode.setName(role.getName());
            roleNode.setPid(role.getpId());
            roleNode.setChecked(role.getChecked());
            nodes.add(roleNode);
        }
        return nodes;
    }
    public Role getRoleByID(Long id) {
        return roleMapper.selectByPrimaryKey(id);
    }

    public List<Role> findByName(String name) {
        return roleMapper.findByName(name);
    }
}
