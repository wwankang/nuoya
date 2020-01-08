package com.qiafengqishi.nuoya.domain.device;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Device {
    private Long id;

    private String code;

    private String name;

    private String location;

    /**
     * 设备类型ID
     */
    private Long deviceTypeId;

    private LocalDateTime productionTime;

    private LocalDateTime expiredTime;

    private LocalDateTime storeTime;

}
