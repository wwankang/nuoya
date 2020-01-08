// Copyright (C) 2018 7qi
// All rights reserved
package com.qiafengqishi.nuoya.web;


import com.qiafengqishi.nuoya.repository.dao.MyUser;
import com.qiafengqishi.nuoya.repository.mapper.MyUserMapper;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 * @author zhangqi
 * @version 1.0
 * @created 2018/12/9 下午10:27
 **/
@Controller
@RequestMapping(value = "/user")
@ResponseBody
public class UserController {

    @Resource
    private MyUserMapper myUserMapper;


    @GetMapping(value = "/{id}")
    public String user(@PathVariable("id") Long id ){
        MyUser user2 = myUserMapper.selectByPrimaryKey(id);
        return user2.toString();
    }


}