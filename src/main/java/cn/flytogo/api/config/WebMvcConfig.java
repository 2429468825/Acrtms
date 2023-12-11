package cn.flytogo.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

/**
 * @Description
 * @Author
 * @Date
 **/

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
//    @Bean //将组件注册在容器
//    public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
//        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
//            @Override
//            public void addViewControllers(ViewControllerRegistry registry) {
//                registry.addViewController("/fileDisplay.html").setViewName("fileDisplay");
//            };
//        };
//        return adapter;
//    }

}
