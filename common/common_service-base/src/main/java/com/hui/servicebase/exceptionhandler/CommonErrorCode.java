package com.hui.servicebase.exceptionhandler;


/**
 * @author lihui
 * @title: CommonErrorCode
 * @projectName self_discipline_freedom
 * @description: TODO
 * 异常编码 0成功、-1熔断、 -2 标准参数校验不通过 -3会话超时
 * 前两位:服务标识
 * 中间两位:模块标识
 * 后两位:异常标识
 * @date 2020/12/11 9:35
 */
public enum CommonErrorCode implements ErrorCode {

    /** 公用异常编码 **/

    /**
     * 传入参数与接口不匹配
     */
    E_100101(100101,"传入参数与接口不匹配"),
    /**
     * 验证码错误
     */
    E_100102(100102,"验证码错误"),
    /**
     * 验证码为空
     */
    E_100103(100103,"验证码为空"),
    /**
     * 查询结果为空
     */
    E_100104(100104,"查询结果为空"),
    /**
     * ID格式不正确或超出Long存储范围
     */
    E_100105(100105,"ID格式不正确或超出Long存储范围"),
    /**
     * 上传出错
     */
    E_100106(100106,"上传错误"),
    E_100107(100107,"发送验证码错误"),
    E_100108(100108,"入参不全"),

    /**
     * 特殊异常编码
     */
    E_999991(999991,"调用微服务-授权服务 被熔断"),
    E_999992(999992,"调用微服务-用户服务 被熔断"),
    E_999993(999993,"调用微服务-资源服务 被熔断"),
    E_999994(999994,"调用微服务-同步服务 被熔断"),

    E_999910(999910,"调用微服务-没有传tenantId租户Id"),
    E_999911(999911,"调用微服务-没有json-token令牌"),
    E_999912(999912,"调用微服务-json-token令牌解析有误"),
    E_999913(999913,"调用微服务-json-token令牌有误-没有当前租户信息"),
    E_999914(999914,"调用微服务-json-token令牌有误-该租户下没有权限信息"),

    E_NO_AUTHORITY(999997,"没有访问权限"),
    CUSTOM(999998,"自定义异常"),
    /**
     * 未知错误
     */
    UNKOWN(999999,"未知错误");


    private int code;
    private String desc;

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getDesc() {
        return desc;
    }

    private CommonErrorCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }


    public static CommonErrorCode setErrorCode(int code) {
        for (CommonErrorCode errorCode : CommonErrorCode.values()) {
            if (errorCode.getCode()==code) {
                return errorCode;
            }
        }
        return null;
    }
    }



