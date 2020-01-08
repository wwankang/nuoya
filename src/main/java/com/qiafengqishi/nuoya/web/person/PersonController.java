package com.qiafengqishi.nuoya.web.person;



import com.qiafengqishi.nuoya.web.AjaxResult;
import com.qiafengqishi.nuoya.web.person.command.UserRegisterCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/user")
@ResponseBody
@Slf4j
public class PersonController {
    @Autowired
    private PersonService personService;



    /**
     * 注册
     * @param registerCommand
     * @return
     */
    @PostMapping(value = "/register")
    public String register(@RequestBody UserRegisterCommand registerCommand) {
        if (!registerCommand.isValid()) {
            return AjaxResult.failAlert("参数错误！");
        }

        boolean isRegistered = personService.isRegistered(registerCommand.getPhone(), registerCommand.getCode());
        if (isRegistered) {
            return AjaxResult.failAlert("账号已经注册过！");
        }

        personService.register(registerCommand);

        return AjaxResult.success();

    }





}
