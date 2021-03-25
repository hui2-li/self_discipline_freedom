package com.hui.bobcatweb.controller;

import com.hui.bobcatweb.feign.BobcatMainFeign;
import com.hui.bobcatweb.util.IPUtil;
import com.hui.commonutils.R;
import com.hui.commonutils.been.BobcatParameter;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lihui
 * @title: BobcatMainController
 * @projectName self_discipline_freedom
 * @description: TODO
 * @date 2020/12/1514:43
 */
@Api("bobcat接口负载")
@RestController
@RequestMapping("/mes/bobcat")
@Slf4j
public class BobcatMainController {

    @Resource
    private BobcatMainFeign bobcatMainFeign;


    @ApiOperation("bobcat的ADD_RECORD接口")
    @RequestMapping(value = "/index.cgi")
    public String BobCat(HttpServletRequest request) throws Exception {
        Map<String, String[]> parameterMap = new HashMap<String, String[]>(request.getParameterMap());
        String s = "";
        StringBuffer sb = new StringBuffer("");
        //记录日志
        if (!"TEST_CONNECTION".equals(s)) {
            parameterMap.forEach((k, v) ->
                    sb.append("\t\nkey: " + k + "  value: " + Arrays.toString(v))
            );
            log.info("\t\nIP: " + request.getRemoteAddr() +
                    "\t\nURL: " + IPUtil.getIpAddress(request) +
                    "\t\nURL: " + IPUtil.getLocalHostIP() +
                    "\t\nCommand : " + s +
                    "\t\nQueryString: " + request.getQueryString() +
                    "\t\nContent-Type: " + request.getHeader("Content-Type") +
                    sb);

            /*System.out.println("打印接受数据"+"\t\nIP: " + request.getRemoteAddr() +
                    "\t\nURL: " + IPUtil.getIpAddress(request) +
                    "\t\nURL: " + IPUtil.getLocalHostIP() +
                    "\t\nCommand : " + s +
                    "\t\nQueryString: " + request.getQueryString() +
                    "\t\nContent-Type: " + request.getHeader("Content-Type") +
                    sb);*/
        }
        BobcatParameter params = new BobcatParameter();
        params.setSn(request.getParameter("sn"));
        params.setDefect(request.getParameter("defect"));
        params.setInProcessTime(request.getParameter("start_time"));
        params.setOutProcessTime(request.getParameter("stop_time"));
        params.setVersion(request.getParameter("sw_version"));
        params.setMacAddress(request.getParameter("mac_address"));
        params.setStationId(request.getParameter("station_id"));
        params.setProduct(request.getParameter("product"));
        params.setAuditMode(request.getParameter("audit_mode"));
        params.setResult(request.getParameter("result"));
        params.setBobcatSignature(request.getParameter("bobcat_signature"));
        params.setCgSn(request.getParameter("cg_sn"));
        params.setFailureMessage(request.getParameter("failure_message"));
        params.setFixtureId(request.getParameter("fixture_id"));
        params.setFt1LowerLimit(request.getParameter("ft_1_lower_limit"));
        params.setFt1Message(request.getParameter("ft_1_message"));
        params.setFt1SubSubTest(request.getParameter("ft_1_sub_sub_test"));
        params.setFt1SubTest(request.getParameter("ft_1_sub_test"));
        params.setFt1Test(request.getParameter("ft_1_test"));
        params.setFt1Units(request.getParameter("ft_1_units"));
        params.setFt1UpperLimit(request.getParameter("ft_1_upper_limit"));
        params.setFt1Value(request.getParameter("ft_1_value"));
        params.setFt2LowerLimit(request.getParameter("ft_2_lower_limit"));
        params.setFt2Message(request.getParameter("ft_2_message"));
        params.setFt2SubSubTest(request.getParameter("ft_2_sub_sub_test"));
        params.setFt2SubTest(request.getParameter("ft_2_sub_test"));
        params.setFt2Test(request.getParameter("ft_2_test"));
        params.setFt2Units(request.getParameter("ft_2_units"));
        params.setFt2UpperLimit(request.getParameter("ft_2_upper_limit"));
        params.setFt2Value(request.getParameter("ft_2_value"));
        params.setFt3LowerLimit(request.getParameter("ft_3_lower_limit"));
        params.setFt3Message(request.getParameter("ft_3_message"));
        params.setFt3SubSubTest(request.getParameter("ft_3_sub_sub_test"));
        params.setFt3SubTest(request.getParameter("ft_3_sub_test"));
        params.setFt3Test(request.getParameter("ft_3_test"));
        params.setFt3Units(request.getParameter("ft_3_units"));
        params.setFt3UpperLimit(request.getParameter("ft_3_upper_limit"));
        params.setFt3Value(request.getParameter("ft_3_value"));
        params.setFt4LowerLimit(request.getParameter("ft_4_lower_limit"));
        params.setFt4Message(request.getParameter("ft_4_message"));
        params.setFt4SubSubTest(request.getParameter("ft_4_sub_sub_test"));
        params.setFt4SubTest(request.getParameter("ft_4_sub_test"));
        params.setFt4Test(request.getParameter("ft_4_test"));
        params.setFt4Units(request.getParameter("ft_4_units"));
        params.setFt4UpperLimit(request.getParameter("ft_4_upper_limit"));
        params.setFt4Value(request.getParameter("ft_4_value"));
        params.setFt5LowerLimit(request.getParameter("ft_5_lower_limit"));
        params.setFt5Message(request.getParameter("ft_5_message"));
        params.setFt5SubSubTest(request.getParameter("ft_5_sub_sub_test"));
        params.setFt5SubTest(request.getParameter("ft_5_sub_test"));
        params.setFt5Test(request.getParameter("ft_5_test"));
        params.setFt5Units(request.getParameter("ft_5_units"));
        params.setFt5UpperLimit(request.getParameter("ft_5_upper_limit"));
        params.setFt5Value(request.getParameter("ft_5_value"));
        params.setLcgSn(request.getParameter("lcg_sn"));
        params.setListOfFailingTests(request.getParameter("list_of_failing_tests"));
        params.setMlbsn(request.getParameter("mlbsn"));
        params.setOverride(request.getParameter("override"));
        params.setSbuild(request.getParameter("sbuild"));
        params.setStationString(request.getParameter("station_string"));
        params.setTestHeadId(request.getParameter("test_head_id"));

        params.setErrCode(request.getParameter("errCode"));
        params.setErrString(request.getParameter("errString"));
        params.setCarrierPn(request.getParameter("carrier_pn"));
        params.setCarrierDcId(request.getParameter("CarrierDcID"));
        if (bobcatMainFeign.bobCat(params)){
            return "0 SFC_OK";
        }else {
            return "1 SFC_ERROR";
        }
    }


}
