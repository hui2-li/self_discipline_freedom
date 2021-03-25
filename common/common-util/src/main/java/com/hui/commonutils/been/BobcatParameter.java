package com.hui.commonutils.been;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.util.List;

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

    //调用存储过程需要的字段
    private String terminalId;
    private String sn;
    private List<String> defectList;
    private String defect;
    private String nowTime;
    private String emp;
    private String inProcessTime;
    private String outProcessTime;
    private String version;
    private String macAddress;
    private String stationId;
    private String res;
    private String trecId;
    private String nextProc;
    private String product              ;

    //调用cg码的存储过程需要的字段
    private String tcgSn;
    private String processId;
    private String cgsnRes;

    //站点表需要的字段
    private String mainId				;
    private String result               ;
    private String auditMode            ;
    private String bobcatSignature      ;
    private String cgSn                 ;
    private String failureMessage       ;
    private String fixtureId            ;
    private String ft1LowerLimit        ;
    private String ft1Message           ;
    private String ft1SubSubTest        ;
    private String ft1SubTest           ;
    private String ft1Test              ;
    private String ft1Units             ;
    private String ft1UpperLimit        ;
    private String ft1Value             ;
    private String ft2LowerLimit        ;
    private String ft2Message           ;
    private String ft2SubSubTest        ;
    private String ft2SubTest           ;
    private String ft2Test              ;
    private String ft2Units             ;
    private String ft2UpperLimit        ;
    private String ft2Value             ;
    private String ft3LowerLimit        ;
    private String ft3Message           ;
    private String ft3SubSubTest        ;
    private String ft3SubTest           ;
    private String ft3Test              ;
    private String ft3Units             ;
    private String ft3UpperLimit        ;
    private String ft3Value             ;
    private String ft4LowerLimit        ;
    private String ft4Message           ;
    private String ft4SubSubTest        ;
    private String ft4SubTest           ;
    private String ft4Test              ;
    private String ft4Units             ;
    private String ft4UpperLimit        ;
    private String ft4Value             ;
    private String ft5LowerLimit        ;
    private String ft5Message           ;
    private String ft5SubSubTest        ;
    private String ft5SubTest           ;
    private String ft5Test              ;
    private String ft5Units             ;
    private String ft5UpperLimit        ;
    private String ft5Value             ;
    private String lcgSn                ;
    //private String lcmFullSn            ;
    private String listOfFailingTests   ;
    private String mlbsn                ;
    private String override             ;
    private String sbuild               ;
    private String stationString        ;
    private String testHeadId           ;
    private String testStationName      ;

    /**
     * 新加字段（原始bobcat没有这些字段）
     */
    private String errCode              ;
    private String errString            ;
    private String carrierPn            ;
    private String carrierDcId          ;
}
