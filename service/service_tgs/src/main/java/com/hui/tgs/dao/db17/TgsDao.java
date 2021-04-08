package com.hui.tgs.dao.db17;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hui.commonutils.been.TgsParameter;
import org.springframework.stereotype.Component;

/**
 * @author lihui
 * @title: TgsDao
 * @projectName self_discipline_freedom
 * @description: TODO
 * @date 2021/3/2515:36
 */
@Component
public interface TgsDao extends BaseMapper<TgsParameter> {

    /**
     * ADD命令
     */
    void callAdd(TgsParameter tgsParameter);

    /**
     * ATT命令
     */
    void callAtt(TgsParameter tgsParameter);

    /**
     * UOP命令
     */
    void callUop(TgsParameter tgsParameter);

    /**
     * 数据收集(ADD_LOG)
     */
    void callAddLog(TgsParameter tgsParameter);
}
