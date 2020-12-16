package com.hui.bobCat.been;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author lihui
 * @title: SjTransferPdca
 * @projectName self_discipline_freedom
 * @description: TODO
 * @date 2020/12/109:41
 */
@Data
@ApiModel(value="sj_transfer_pdca存储过程参数")
public class SjTransferPdcaInput {

    @ApiModelProperty(value = "站点Id")
    private String terminalId;

    @ApiModelProperty(value = "sn(17码)")
    private String sn;

    @ApiModelProperty(value = "不良")
    private String defect;

    @ApiModelProperty(value = "上传时间")
    private String nowTime;

    @ApiModelProperty(value = "emp")
    private String emp;

    @ApiModelProperty(value = "开始时间")
    private String inProcessTime;

    @ApiModelProperty(value = "结束时间")
    private String outProcessTime;

    @ApiModelProperty(value = "版本")
    private String version;

    @ApiModelProperty(value = "mac地址")
    private String macAddress;

    @ApiModelProperty(value = "tres")
    private String res;

    @ApiModelProperty(value = "tNextProc")
    private String nextProc;

    @ApiModelProperty(value = "trecId(main_id)")
    private String trecId;

}
