package com.qiafengqishi.nuoya.domain.agent;

import java.time.LocalDateTime;

/**
 * 申请
 */
public class Application {
    private Long id;

    private String content;//todo 内容？？

    private String agentCode;

    private String deviceCode;

    private LocalDateTime applyTime;


    private String operatorCode;

    private LocalDateTime beginTime;

    private LocalDateTime endTime;


    private Status status;


    public enum Status {
        PENDING,
        PROCESSING,
        REVOKE,
        PROCESSED
    }

}
