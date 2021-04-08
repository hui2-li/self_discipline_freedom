package com.hui.commonutils.been;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
import java.util.Map;

/**
 * @author lihui
 * @title: TgsParameter
 * @projectName self_discipline_freedom
 * @description: TODO
 * @date 2021/3/2515:53
 */
@ApiModel(value="TgsParameter传入参数")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TgsParameter {

    @ApiModelProperty(value = "设备发送两次请求，CMD=UOP(检查流程)，CMD=ADD(所有参数都传过来)")
    private String cmd;

    @ApiModelProperty(value = "关联新的ATT命令,子命令，必要字段")
    private String p;

    @ApiModelProperty(value = "工单，可空")
    private String wo;

    @ApiModelProperty(value = "SN，不可空")
    private String sn;

    @ApiModelProperty(value = "数量 可空")
    private String qty;

    @ApiModelProperty(value = "CSN，可空")
    private String csn;

    @ApiModelProperty(value = "作业员工号，不可空")
    private String op;

    @ApiModelProperty(value = "材料序号，可空")
    private String kpsn;

    @ApiModelProperty(value = "批次物料，可空")
    private String lotno;

    @ApiModelProperty(value = "新加模穴号备用，可空")
    private String cavity;

    @ApiModelProperty(value = "治具，可空")
    private String tooling;

    @ApiModelProperty(value = "机台，可空")
    private String machine;

    @ApiModelProperty(value = "传状态[OK,FAIL,START,STOP]")
    private String status;

    @ApiModelProperty(value = "站点，不可空 ")
    private String terminal;

    @ApiModelProperty(value = "不良代码")
    private String defectCode;

    @ApiModelProperty(value = "除了几个主要参数外,其余的都放到testdata中，不可空")
    private String testData;

    @ApiModelProperty(value = "上传Insight使用到，可空")
    private String results;

    @ApiModelProperty(value = "调用存储过程返回参数TRES")
    private String res;

    @ApiModelProperty(value = "调用存储过程返回参数I_SQL")
    private String sql;

    @ApiModelProperty(value = "strSql")
    private String strSql;

    @ApiModelProperty(value = "sendTime")
    private String sendTime;

}
