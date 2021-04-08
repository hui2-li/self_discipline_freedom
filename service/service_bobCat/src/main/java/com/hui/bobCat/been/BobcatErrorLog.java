package com.hui.bobCat.been;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author lihui
 * @title: BobcatErrorLog
 * @projectName self_discipline_freedom
 * @description: TODO
 * @date 2021/3/268:28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("SAJET.BOBCAT_ERROR_LOG")
@ApiModel(value="存储错误日志", description="站点名称映射表")
public class BobcatErrorLog {

    @ApiModelProperty(value = "二维码")
    @TableField("SN")
    private String sn ;

    @ApiModelProperty(value = "bobcat的站点名称")
    @TableField("PDCA_STATION")
    private String pdcaStation;

    @ApiModelProperty(value = "机种")
    @TableField("PRODUCT")
    private String product;

    @ApiModelProperty(value = "错误类型(ERROR_MAPPING为未添加映射信息，ERROR_SQL为SQL错误)")
    @TableField("ERROR_TYPE")
    private String errorType  ;

    @ApiModelProperty(value = "错误详情")
    @TableField("ERROR_MSG")
    private String errorMsg;

    @ApiModelProperty(value = "bobcat接收的参数")
    @TableField("PARAMETER")
    private String parameter;

    @ApiModelProperty(value = "更新时间")
    @TableField("UPDATETIME")
    private String updateTime;
}
