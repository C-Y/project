package com.it.service.impl;

import com.it.dao.ISysLogDao;
import com.it.domain.SysLog;
import com.it.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SysLogServlceImpl implements ISysLogService{
    //注入dao
    @Autowired
    private ISysLogDao sysLogDao;
    @Override
    //保存
    public void save(SysLog log) {
        sysLogDao.save(log);
    }
}
