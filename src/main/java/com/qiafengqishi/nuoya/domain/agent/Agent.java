package com.qiafengqishi.nuoya.domain.agent;

import lombok.Data;

/**
 * 坐席
 */
@Data
public class Agent {
    private Long id;

    private String code;

    private String name;

    private String phone;

    private String location;

    public enum Status {
        NORMAL,
        INVALID
    }


    //需要申请、审批等流程吗？？
}
