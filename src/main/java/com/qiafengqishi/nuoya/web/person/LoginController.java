package com.qiafengqishi.nuoya.web.person;

import com.qiafengqishi.nuoya.authentic.TokenUtil;
import com.qiafengqishi.nuoya.repository.dao.PersonPO;
import com.qiafengqishi.nuoya.web.AjaxResult;
import com.qiafengqishi.nuoya.web.person.command.UserLoginCommand;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping(value = "")
@ResponseBody
@Slf4j
public class LoginController {

    @Autowired
    private PersonService personService;

    /**
     * 登陆
     * @return
     */
    @PostMapping(value = "/login")
    public String user(@RequestBody UserLoginCommand command){
        log.info("[PersonController] user loginIn! command:{}", command);
        if (!command.isValid()) {
            return AjaxResult.failAlert("参数错误！");
        }
        boolean isValid = false;
        //校验密码是否对、状态是否有效！！  //fixme 这里可以先不获取一遍数据库！！
        PersonPO personPO = null;
        if (null != command.getPhone()) {
            personPO = personService.loginByPhone(command.getPhone(), command.getPassword());
        } else if (null != command.getCode()) {
            personPO = personService.loginByCode(command.getCode(), command.getPassword());
        } else {
            return AjaxResult.failAlert("用户名或密码错误！");
        }
        if (null == personPO) {
            return AjaxResult.failAlert("用户名或密码错误！");
        }

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(command.getCode(), command.getPassword());
        subject.login(usernamePasswordToken);
        String token = TokenUtil.getToken(personPO.getName(),  personPO.getId() + "", personPO.getPassWord());
        return AjaxResult.success(token);




    }

    @PutMapping(value = "/logout")
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        //注销
        subject.logout();
        return AjaxResult.success("成功注销！");
    }

}
