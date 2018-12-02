package com.atguigu.springboot.config;

import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * DefaultErrorAttributes 是输出错误数据用的 在这里可以重写该类 添加我们想要的数据
 */
@Component
public class CustomerErrorAttributes extends DefaultErrorAttributes {
    @Override
    public Map<String, Object> getErrorAttributes(RequestAttributes requestAttributes, boolean includeStackTrace) {
        Map<String, Object> errorAttributes = super.getErrorAttributes(requestAttributes, includeStackTrace);
        errorAttributes.put("data",requestAttributes.getAttribute("data",RequestAttributes.SCOPE_REQUEST));
        errorAttributes.put("company","atguigu");
        return errorAttributes;
    }
}
