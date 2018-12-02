package com.atguigu.springboot.config;

import com.atguigu.springboot.config.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        super.addViewControllers(registry);
        registry.addViewController("/")
                .setViewName("login");
        registry.addViewController("/index.html")
                .setViewName("login");
        registry.addViewController("/main.html")
                .setViewName("dashboard");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
        /*registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/","/index.html","/login");*/
    }

    /**
     * 配置localeResolver
     * 方法名即是返回的bean名称 必须和springboot配置的名称一样才可以生效
     * @return
     */
    @Bean
    public LocaleResolver localeResolver(){
        return new CustomLocaleResolver();
    }

}
