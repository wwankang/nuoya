package com.qiafengqishi.nuoya.web.WorkOrder.impl;

import com.qiafengqishi.nuoya.repository.dao.ReprotedPersonPO;
import com.qiafengqishi.nuoya.repository.mapper.ReprotedPersonPOMapper;
import com.qiafengqishi.nuoya.server.DateUtils;
import com.qiafengqishi.nuoya.web.WorkOrder.ReprotedPersonService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.LocalDateTime;

@Component
public class ReprotedPersonServiceImpl implements ReprotedPersonService {
    @Resource
    private ReprotedPersonPOMapper reprotedPersonPOMapper;

    @Override
    public void store(ReprotedPersonPO reprotedPersonPO) {

        reprotedPersonPO.setAddTime(DateUtils.now());
        reprotedPersonPO.setUpdateTime(DateUtils.now());
        reprotedPersonPOMapper.insert(reprotedPersonPO);
    }

    @Override
    public ReprotedPersonPO findById(Long reportedPersonId) {
        ReprotedPersonPO personPO = reprotedPersonPOMapper.selectByPrimaryKey(reportedPersonId);
        return personPO;
    }
}
