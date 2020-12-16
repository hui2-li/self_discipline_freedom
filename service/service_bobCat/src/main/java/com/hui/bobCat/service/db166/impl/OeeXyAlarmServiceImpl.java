package com.hui.bobCat.service.db166.impl;

import com.hui.bobCat.been.OeeXyAlarm;
import com.hui.bobCat.dao.db166.OeeXyAlarmDAO;
import com.hui.bobCat.service.db166.OeeXyAlarmService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lihui
 * @since 2020-12-01
 */
@Service
public class OeeXyAlarmServiceImpl extends ServiceImpl<OeeXyAlarmDAO, OeeXyAlarm> implements OeeXyAlarmService {

    @Autowired
    private OeeXyAlarmDAO oeeXyAlarmDAO;

    public List<OeeXyAlarm> testY() {
        return oeeXyAlarmDAO.testY();
    }
}
