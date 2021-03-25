package com.hui.bobCat.been;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 站点名称映射表
 * </p>
 *
 * @author lihui
 * @since 2020-12-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("SAJET.BOBCAT_STATION_MAPPING")
@ApiModel(value="BobcatStationMapping对象", description="站点名称映射表")
public class BobcatStationMapping implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "bobcat的站点名称")
    @TableField("PDCA_STATION")
    private String pdcaStation;

    @ApiModelProperty(value = "mes站点")
    @TableField("MES_TERMINAL")
    private String mesTerminal;

    @ApiModelProperty(value = "是否有效")
    @TableField("ENABLED")
    private String enabled;

    @ApiModelProperty(value = "站点表名")
    @TableField("STATION_TABLE_NAME")
    private String stationTableName;

    @ApiModelProperty(value = "机种")
    @TableField("PRODUCT")
    private String product;

    @ApiModelProperty(value = "创建时间")
    @TableField("CREATE_TIME")
    private String createTime;

}
