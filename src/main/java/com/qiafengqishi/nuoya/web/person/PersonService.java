package com.qiafengqishi.nuoya.web.person;

import com.qiafengqishi.nuoya.repository.dao.PersonPO;
import com.qiafengqishi.nuoya.web.person.command.UserRegisterCommand;

public interface PersonService {
    PersonPO loginByPhone(String phone, String password);

    PersonPO loginByCode(String code, String password);

    boolean isRegistered(String phone, String code);

    void register(UserRegisterCommand registerCommand);
}
