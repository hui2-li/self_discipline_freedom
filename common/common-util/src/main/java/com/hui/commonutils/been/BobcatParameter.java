package com.hui.commonutils.been;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

/**
 * @author lihui
 * @title: BobcatParameter
 * @projectName self_discipline_freedom
 * @description: TODO
 * @date 2020/12/1514:41
 */
@Data
@ApiModel(value="BobcatParameter参数")
@ToString
public class BobcatParameter {

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

    @ApiModelProperty(value = "机种")
    private String product;

    @ApiModelProperty(value = "站点名称")
    private String stationName;

    @TableField("MAIN_ID")
    private String mainId;

    @TableField("UPLOAD_TIME")
    private String uploadTime;

    @TableField("AUDIT_MODE")
    private String auditMode;

    @TableField("BOBCAT_SIGNATURE")
    private String bobcatSignature;

    @TableField("FT_1_LOWER_LIMIT")
    private String ft1LowerLimit;

    @TableField("FT_1_MESSAGE")
    private String ft1Message;

    @TableField("FT_1_SUB_SUB_TEST")
    private String ft1SubSubTest;

    @TableField("FT_1_SUB_TEST")
    private String ft1SubTest;

    @TableField("FT_1_TEST")
    private String ft1Test;

    @TableField("FT_1_UNITS")
    private String ft1Units;

    @TableField("FT_1_UPPER_LIMIT")
    private String ft1UpperLimit;

    @TableField("FT_1_VALUE")
    private String ft1Value;

    @TableField("FT_2_LOWER_LIMIT")
    private String ft2LowerLimit;

    @TableField("FT_2_MESSAGE")
    private String ft2Message;

    @TableField("FT_2_SUB_SUB_TEST")
    private String ft2SubSubTest;

    @TableField("FT_2_SUB_TEST")
    private String ft2SubTest;

    @TableField("FT_2_TEST")
    private String ft2Test;

    @TableField("FT_2_UNITS")
    private String ft2Units;

    @TableField("FT_2_UPPER_LIMIT")
    private String ft2UpperLimit;

    @TableField("FT_2_VALUE")
    private String ft2Value;

    @TableField("FT_3_LOWER_LIMIT")
    private String ft3LowerLimit;

    @TableField("FT_3_MESSAGE")
    private String ft3Message;

    @TableField("FT_3_SUB_SUB_TEST")
    private String ft3SubSubTest;

    @TableField("FT_3_SUB_TEST")
    private String ft3SubTest;

    @TableField("FT_3_TEST")
    private String ft3Test;

    @TableField("FT_3_UNITS")
    private String ft3Units;

    @TableField("FT_3_UPPER_LIMIT")
    private String ft3UpperLimit;

    @TableField("FT_3_VALUE")
    private String ft3Value;

    @TableField("FT_4_LOWER_LIMIT")
    private String ft4LowerLimit;

    @TableField("FT_4_MESSAGE")
    private String ft4Message;

    @TableField("FT_4_SUB_SUB_TEST")
    private String ft4SubSubTest;

    @TableField("FT_4_SUB_TEST")
    private String ft4SubTest;

    @TableField("FT_4_TEST")
    private String ft4Test;

    @TableField("FT_4_UNITS")
    private String ft4Units;

    @TableField("FT_4_UPPER_LIMIT")
    private String ft4UpperLimit;

    @TableField("FT_4_VALUE")
    private String ft4Value;

    @TableField("FT_5_LOWER_LIMIT")
    private String ft5LowerLimit;

    @TableField("FT_5_MESSAGE")
    private String ft5Message;

    @TableField("FT_5_SUB_SUB_TEST")
    private String ft5SubSubTest;

    @TableField("FT_5_SUB_TEST")
    private String ft5SubTest;

    @TableField("FT_5_TEST")
    private String ft5Test;

    @TableField("FT_5_UNITS")
    private String ft5Units;

    @TableField("FT_5_UPPER_LIMIT")
    private String ft5UpperLimit;

    @TableField("FT_5_VALUE")
    private String ft5Value;

    @TableField("LCG_SN")
    private String lcgSn;

    @TableField("OVERRIDE")
    private String override;

    @TableField("FIXTURE_ID")
    private String fixTrueId;

    @TableField("STATION_STRING")
    private String stationString;

    @TableField("TEST_HEAD_ID")
    private String testHeadId;

}
