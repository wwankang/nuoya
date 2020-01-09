package com.qiafengqishi.nuoya.web.system;

import com.qiafengqishi.nuoya.domain.node.MenuNode;
import com.qiafengqishi.nuoya.domain.node.Node;
import com.qiafengqishi.nuoya.domain.node.RouterMenu;
import com.qiafengqishi.nuoya.domain.node.ZTreeNode;
import com.qiafengqishi.nuoya.repository.dao.Menu;
import com.qiafengqishi.nuoya.repository.dao.User;
import com.qiafengqishi.nuoya.repository.mapper.MenuMapper;
import com.qiafengqishi.nuoya.repository.mapper.UserMapper;
import com.qiafengqishi.nuoya.service.system.MenuService;
import com.qiafengqishi.nuoya.utils.Convert;
import com.qiafengqishi.nuoya.utils.Lists;
import com.qiafengqishi.nuoya.utils.Maps;
import com.qiafengqishi.nuoya.web.AjaxResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * MenuController
 *
 * @author enilu
 * @version 2018/9/12 0012
 */
@RestController
@RequestMapping("/menu")
public class MenuController {

    private Logger logger = LoggerFactory.getLogger(MenuController.class);

    @Resource
    private UserMapper userMapper;
    @Resource
    private MenuMapper menuMapper;

    @Autowired
    private MenuService menuService;

    @RequestMapping(value = "/listForRouter", method = RequestMethod.GET)
    public Object listForRouter() {
        //获取当前用户
        User user = userMapper.selectByPrimaryKey(1L);
        String roleid = user.getRoleid();
        Long[] roleArray = Convert.toLongArray(",", roleid);

        List<RouterMenu> list = menuService.getSideBarMenus(roleArray);
        return AjaxResult.success(list);
    }
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Object list() {
        List<MenuNode> list = menuService.getMenus();
        return AjaxResult.success(list);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Object save(@ModelAttribute @Valid Menu menu) {
        //判断是否存在该编号
        if(menu.getId()==null) {
            if (menuService.findByCode(menu.getCode()) != null) {
                return AjaxResult.failAlert("菜单编号重复，不能添加");
            }
            menu.setStatus(1);
        }

        //设置父级菜单编号
        menuService.menuSetPcode(menu);
        if(menu.getId()==null){
            menuMapper.insert(menu);
        }else {
            menuMapper.updateByPrimaryKey(menu);
        }
        return AjaxResult.success();
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public Object remove(@RequestParam Long id) {
        logger.info("id:{}", id);
        if (id == null) {
            return AjaxResult.failAlert("菜单id获取失败");
        }
        //演示环境不允许删除初始化的菜单
//        if(id.intValue()<70){
//            return Rets.failure("演示环境不允许删除初始菜单");
//        }
        //缓存菜单的名称
        menuService.delMenuContainSubMenus(id);
        return AjaxResult.success();
    }

    /**
     * 获取菜单树
     */
    @RequestMapping(value = "/menuTreeListByRoleId", method = RequestMethod.GET)
    public Object menuTreeListByRoleId(Integer roleId) {
        List<Long> menuIds = menuService.getMenuIdsByRoleId(roleId);
        List<ZTreeNode> roleTreeList = null;
        if (menuIds==null||menuIds.isEmpty()) {
            roleTreeList = menuService.menuTreeList(null);
        } else {
            roleTreeList = menuService.menuTreeList(menuIds);

        }
        List<Node> list = menuService.generateMenuTreeForRole(roleTreeList);

        //element-ui中tree控件中如果选中父节点会默认选中所有子节点，所以这里将所有非叶子节点去掉
        Map<Long,ZTreeNode> map = Lists.toMap(roleTreeList,"id");
        Map<Long,List<ZTreeNode>> group = Lists.group(roleTreeList,"pId");
        for(Map.Entry<Long,List<ZTreeNode>> entry:group.entrySet()){
            if(entry.getValue().size()>1){
                roleTreeList.remove(map.get(entry.getKey()));
            }
        }

        List<Long> checkedIds = Lists.newArrayList();
        for (ZTreeNode zTreeNode : roleTreeList) {
            if (zTreeNode.getChecked() != null && zTreeNode.getChecked()
                    &&zTreeNode.getpId().intValue()!=0) {
                checkedIds.add(zTreeNode.getId());
            }
        }
        return AjaxResult.success(Maps.newHashMap("treeData", list, "checkedIds", checkedIds));
    }

}
