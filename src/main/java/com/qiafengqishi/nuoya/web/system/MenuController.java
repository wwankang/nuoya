package com.qiafengqishi.nuoya.web.system;

import com.qiafengqishi.nuoya.domain.node.RouterMenu;
import com.qiafengqishi.nuoya.repository.dao.User;
import com.qiafengqishi.nuoya.repository.mapper.UserMapper;
import com.qiafengqishi.nuoya.service.system.MenuService;
import com.qiafengqishi.nuoya.utils.Convert;
import com.qiafengqishi.nuoya.web.AjaxResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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

}
