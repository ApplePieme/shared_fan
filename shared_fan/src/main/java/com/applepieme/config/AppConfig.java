package com.applepieme.config;

import com.applepieme.filter.LoginFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 全局配置类
 *
 * @author applepieme
 * @date 2021/6/23 0:53
 */
@Configuration
public class AppConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginFilter())
                .addPathPatterns("/**")
                .excludePathPatterns("/user/login")
                .excludePathPatterns("/user/register");
    }
}
