package com.qiafengqishi.nuoya.domain;

import lombok.Data;

@Data
public class RoleTree {
    private Long id;
    private Long pId;
    private String name;
    private String open;
    private String checked;
}
