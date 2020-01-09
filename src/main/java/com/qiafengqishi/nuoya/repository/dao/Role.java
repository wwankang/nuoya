package com.qiafengqishi.nuoya.repository.dao;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
public class Role {
    private Long id;

    private Long createBy;

    private Date createTime;

    private Long modifyBy;

    private Date modifyTime;

    private Long deptid;

    @NotBlank(message = "角色名称不能为空")
    private String name;

    private Integer num;

    private Long pid;

    private String tips;

    private Integer version;

}