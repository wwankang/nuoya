// Copyright (C) 2018 7qi
// All rights reserved
package com.qiafengqishi.nuoya.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zhangqi
 * @version 1.0
 * @created 2018/12/16 下午11:03
 **/
@Controller
@RequestMapping("/welcome")
@ResponseBody
public class WelcomeController {

    @RequestMapping("")
    public String index(ModelMap map) {
        // 加入一个属性，用来在模板中读取
        map.addAttribute("name", "时珍");
        map.addAttribute("event", "我爱你！");
        // return模板文件的名称，对应src/main/resources/templates/welcome.html
        return AjaxResult.success("welcome");
    }
    @RequestMapping("/index")
    public String index2(ModelMap map) {
        // 加入一个属性，用来在模板中读取
        map.addAttribute("name", "时珍");
        map.addAttribute("event", "我爱你！");
        // return模板文件的名称，对应src/main/resources/templates/welcome.html
        return "/index";
    }

    @RequestMapping("/memos")
    public String memos(ModelMap map) {
        // 加入一个属性，用来在模板中读取
        map.addAttribute("name", "时珍");
        map.addAttribute("event", "我爱你！");
        // return模板文件的名称，对应src/main/resources/templates/welcome.html
        return "/memos";
    }
//    @GetMapping("/index")
//    public ModelAndView commentsIndex(ModelMap map) {
//        ModelAndView mav = new ModelAndView("/index");
//
//
//        //说明：在这里可以控制不生成静态htm
//        mav.addObject("CREATE_HTML", false);
//        return mav;
//    }
}