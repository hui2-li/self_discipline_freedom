package com.hui.tgs.service.db17;


import com.baomidou.mybatisplus.extension.service.IService;
import com.hui.commonutils.been.TgsParameter;

/**
 * @author lihui
 * @title: TgsService
 * @projectName self_discipline_freedom
 * @description: TODO
 * @date 2020/12/1010:39
 */
public interface TgsService extends IService<TgsParameter> {

    public String tgsToDealWith(TgsParameter tgsParameter);

}
