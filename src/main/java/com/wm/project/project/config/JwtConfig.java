package com.wm.project.project.config;

import com.wm.project.project.Interceptor.TokenInterceptor;
import com.wm.project.project.util.FileProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * @author zyf
 * @since 2022/3/23 16:32
 */
@Configuration
public class JwtConfig  implements WebMvcConfigurer {

    @Resource
    private FileProperties fileProperties;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
            registry.addInterceptor(new TokenInterceptor()).addPathPatterns("/**")
                    .excludePathPatterns("/users/login")
                    .excludePathPatterns("/file/**")
                    .excludePathPatterns("/users/loginByJwt")
                    .excludePathPatterns("/users/test2")
                    .excludePathPatterns("/users/test")
                    .excludePathPatterns("/users/demo2")
                    .excludePathPatterns("/users/loginInsert")
                    .excludePathPatterns("/users/**")
                    .excludePathPatterns("/users/IsCancellation");


    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //addResourceHandler是指你想在url请求的路径
        //addResourceLocations是图片存放的真实路径

        registry.addResourceHandler(fileProperties.getFilePath())
                .addResourceLocations("file:" + fileProperties.getUploadFolder());

    }

}
