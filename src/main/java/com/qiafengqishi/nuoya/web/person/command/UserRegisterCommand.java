package com.qiafengqishi.nuoya.web.person.command;


import lombok.Data;

@Data
public class UserRegisterCommand {
    private String name;

    private String code;

    private String phone;

    private String password;

    private String status;

    private String location;

    private String userType;

    public boolean isValid() {
        if (null == this) {
            return false;
        }
        if (null == code && null == phone) {
            return false;
        }
        if (null == password) {
            return false;
        }
        if (null == userType) {
            return false;
        }
        return true;
    }
}
