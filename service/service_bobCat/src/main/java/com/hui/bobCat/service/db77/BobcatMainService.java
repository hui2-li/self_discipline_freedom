package com.hui.bobCat.service.db77;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hui.bobCat.been.BobcatErrorLog;
import com.hui.bobCat.been.SjTransferPdcaInput;
import com.hui.commonutils.R;
import com.hui.commonutils.been.BobcatParameter;

/**
 * @author lihui
 * @title: BobcatMain
 * @projectName self_discipline_freedom
 * @description: TODO
 * @date 2020/12/1010:39
 */
public interface BobcatMainService extends IService<SjTransferPdcaInput>{

     Boolean bobcatInfoDeal(BobcatParameter params);


}
