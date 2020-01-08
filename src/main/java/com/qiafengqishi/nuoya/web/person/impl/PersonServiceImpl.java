package com.qiafengqishi.nuoya.web.person.impl;

import com.qiafengqishi.nuoya.repository.dao.PersonPO;
import com.qiafengqishi.nuoya.repository.dao.ServiceCenterAgentPO;
import com.qiafengqishi.nuoya.repository.mapper.PersonPOMapper;
import com.qiafengqishi.nuoya.repository.mapper.ServiceCenterAgentMapper;
import com.qiafengqishi.nuoya.web.person.PersonService;
import com.qiafengqishi.nuoya.web.person.command.UserRegisterCommand;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.beans.Transient;

@Component
public class PersonServiceImpl implements PersonService {

    @Resource
    private PersonPOMapper personPOMapper;
    @Resource
    private ServiceCenterAgentMapper serviceCenterAgentMapper;


    @Override
    public PersonPO loginByPhone(String phone, String password) {
        PersonPO personPO = personPOMapper.selectByPhone(phone);
        if (null == personPO) {
            return null;
        }
        if (!(password + "").equals(personPO.getPassWord())) {
            return null;
        }
        return personPO;
    }

    @Override
    public PersonPO loginByCode(String code, String password) {
        PersonPO personPO = personPOMapper.selectByCode(code);
        if (null == personPO) {
            return null;
        }
        if (!(password + "").equals(personPO.getPassWord())) {
            return null;
        }
        return personPO;
    }

    @Override
    public boolean isRegistered(String phone, String code) {
        if (null == phone && null == code) {
            return true;
        }
        if (null != phone) {
            PersonPO personPO = personPOMapper.selectByPhone(phone);
            if (null != personPO) {
                return true;
            }
        }

        if (null != code) {
            PersonPO personPO = personPOMapper.selectByCode(code);
            if (null != personPO) {
                return true;
            }
        }

        return false;
    }

    @Override
    @Transient
    public void register(UserRegisterCommand command) {
        PersonPO personPO = new PersonPO();
        personPO.setCode(command.getCode());
        personPO.setName(command.getName());
        personPO.setPhone(command.getPhone());
        personPO.setPassWord(command.getPassword());
//        personPO.setStatus();//todo 类中加状态！！
        personPOMapper.insert(personPO);

        if ("ServiceCenterAgent".equals(command.getUserType())) {
            ServiceCenterAgentPO serviceCenterAgentPO = new ServiceCenterAgentPO();
            serviceCenterAgentPO.setPersonId(personPO.getId());

            serviceCenterAgentMapper.insert(serviceCenterAgentPO);
        }
    }


}
