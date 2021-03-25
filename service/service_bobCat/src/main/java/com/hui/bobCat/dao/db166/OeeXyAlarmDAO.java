package com.hui.bobCat.dao.db166;

import com.hui.bobCat.been.OeeXyAlarm;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lihui
 * @since 2020-12-01
 */
public interface OeeXyAlarmDAO extends BaseMapper<OeeXyAlarm> {

    List<OeeXyAlarm> testY();

}
