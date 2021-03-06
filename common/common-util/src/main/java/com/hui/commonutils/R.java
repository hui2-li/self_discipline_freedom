package com.hui.commonutils;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * 统一返回结果的类（链式编程 R.*.*）
 * @author lihui
 */
@Data
public class R {

    @ApiModelProperty(value = "是否成功")
    private Boolean state;

    @ApiModelProperty(value = "返回码")
    private Integer code;

    @ApiModelProperty(value = "返回消息")
    private String message;

    @ApiModelProperty(value = "返回数据")
    private Map<String, Object> data = new HashMap<String, Object>();

    //把构造方法私有
    private R() {}

    //成功静态方法
    public static R ok() {
        R r = new R();
        r.setState(true);
        r.setCode(ResultCode.SUCCESS);
        r.setMessage("success");
        return r;
    }

    //失败静态方法
    public static R error() {
        R r = new R();
        r.setState(false);
        r.setCode(ResultCode.ERROR);
        r.setMessage("fail");
        return r;
    }

    public R success(Boolean success){
        this.setState(success);
        return this;
    }

    public R message(String message){
        this.setMessage(message);
        return this;
    }

    public R code(Integer code){
        this.setCode(code);
        return this;
    }

    public R data(String key, Object value){
        this.data.put(key, value);
        return this;
    }

    public R data(Map<String, Object> map){
        this.setData(map);
        return this;
    }
}
