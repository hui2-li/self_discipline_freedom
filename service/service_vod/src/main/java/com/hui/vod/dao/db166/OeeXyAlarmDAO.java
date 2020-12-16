package com.hui.vod.dao.db166;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.hui.vod.been.OeeXyAlarm;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lihui
 * @since 2020-12-02
 */
@DS(value = "db166")
@Mapper
public interface OeeXyAlarmDAO extends BaseMapper<OeeXyAlarm> {

}
