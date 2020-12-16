package com.hui.bobCat.been;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author lihui
 * @since 2020-12-01
 */
@Data
@TableName("OEE_XY_ALARM")
@ApiModel(value="OeeXyAlarm对象", description="")
public class OeeXyAlarm implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "OEE_XY_heartbeat 的id")
    @TableField("PID")
    private Double pid;

    @TableField("AN")
    private String an;

    @TableField("AM")
    private String am;


}
