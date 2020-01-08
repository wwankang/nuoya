package com.qiafengqishi.nuoya.web.WorkOrder.impl;

import com.qiafengqishi.nuoya.repository.dao.ReprotedDevicePO;
import com.qiafengqishi.nuoya.repository.mapper.ReprotedDevicePOMapper;
import com.qiafengqishi.nuoya.server.DateUtils;
import com.qiafengqishi.nuoya.web.WorkOrder.ReprotedDeviceService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


@Component
public class ReprotedDeviceServiceImpl implements ReprotedDeviceService {
    @Resource
    private ReprotedDevicePOMapper reprotedDevicePOMapper;

    @Override
    public void store(ReprotedDevicePO reprotedDevicePO) {
        reprotedDevicePO.setAddTime(DateUtils.now());
        reprotedDevicePO.setUpdateTime(DateUtils.now());
        reprotedDevicePOMapper.insert(reprotedDevicePO);
    }

    @Override
    public ReprotedDevicePO findById(Long reportedDeviceId) {
        ReprotedDevicePO reprotedDevicePO = reprotedDevicePOMapper.selectByPrimaryKey(reportedDeviceId);
        return reprotedDevicePO;
    }
}
