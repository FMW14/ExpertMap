package com.example.ex2.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
    }

//    private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {
//            "classpath:/META-INF/resources/", "classpath:/resources/",
//            "classpath:/static/", "classpath:/public/" };

//    @Override
//    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
//        configurer.enable();
//    }



    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("resources/**")
//                .addResourceLocations("/resources/","/css/","/js/");
//        registry.addResourceHandler("/**")
//                .addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS);
//        registry.addResourceHandler("/static/**")
//                .addResourceLocations("classpath:/static/");
////        registry.addResourceHandler("static/**")
////                .addResourceLocations("classpath:static/");
//        registry.addResourceHandler("/static/js/**")
//                .addResourceLocations("/resources/static/js/");
//        registry
//                .addResourceHandler("/resources/**")
//                .addResourceLocations("/resources/");
//        registry
//                .addResourceHandler("/resources/**")
//                .addResourceLocations("classpath:/resources/");
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
    }

}
