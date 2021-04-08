package com.hui.servicebase.exceptionhandler;

import com.hui.commonutils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 全局异常处理器
 * @author lihui
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 捕获Exception异常(全局异常处理)
     * @param request
     * @param response
     * @param e
     * @return
     */
    //@ExceptionHandler(value = Exception.class)
    //@ResponseBody
    //@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public R processExcetion(HttpServletRequest request,
                                           HttpServletResponse response,
                                           Exception e){
        //解析异常信息
        //如果是系统自定义异常，直接取出errCode和errMessage
        if(e instanceof BusinessException){
            log.error(e.getMessage(),e);
            //解析系统自定义异常信息
            BusinessException businessException= (BusinessException) e;
            ErrorCode errorCode = businessException.getErrorCode();
            //错误代码
            int code = errorCode.getCode();
            //错误信息
            String desc = errorCode.getDesc();
            return R.error().message(String.valueOf(code)+desc+"");
        }

        log.error(String.valueOf(CommonErrorCode.UNKOWN.getCode())+CommonErrorCode.UNKOWN.getDesc());
        //统一定义为99999系统未知错误
        return R.error().message(String.valueOf(CommonErrorCode.UNKOWN.getCode())+CommonErrorCode.UNKOWN.getDesc());

    }

    //特定异常
    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody //为了返回数据
    public R error(ArithmeticException e) {
        e.printStackTrace();
        return R.error().message("执行了ArithmeticException异常处理..");
    }


}
