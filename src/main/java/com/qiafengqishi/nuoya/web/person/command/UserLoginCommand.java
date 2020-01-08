package com.qiafengqishi.nuoya.web.person.command;


import lombok.Data;

@Data
public class UserLoginCommand {
    private String phone;

    private String code;

    private String password;

    public boolean isValid() {
        if (null == this
                || (null == this.getCode() && null == this.getPhone())
                || (null == this.getPassword())) {
            return false;
        }

        return true;
    }
}
