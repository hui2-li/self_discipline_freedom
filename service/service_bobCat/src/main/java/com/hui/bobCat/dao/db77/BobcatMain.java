package com.hui.bobCat.dao.db77;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hui.bobCat.been.SjTransferPdcaInput;
import com.hui.commonutils.been.BobcatParameter;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * @author lihui
 * @title: BobcatMain
 * @projectName self_discipline_freedom
 * @description: TODO
 * @date 2020/12/109:51
 */
@Component
public interface BobcatMain extends BaseMapper<SjTransferPdcaInput> {

    /**
     * 传入存储过in参数，得到Main_id
     * @return
     */
    void queryMainId(BobcatParameter params);

    void queryCgSn(BobcatParameter params);

    /**
     * 获取对应制程下面的表名插入信息
     * @param tableName
     * @param bobcatParameter
     * @return
     */
    public int insertStationTable(@Param("tableName")String tableName,  @Param("params") BobcatParameter bobcatParameter);

}
