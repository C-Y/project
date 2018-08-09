package com.it.dao;

import com.it.domain.SysLog;
import org.apache.ibatis.annotations.Insert;

public interface ISysLogDao {

    //添加log
    @Insert("insert into sys_log(visitTime,username,ip,method)" +
            "values(#{visitTime},#{username},#{ip},#{method})")
    void save(SysLog log);

}
