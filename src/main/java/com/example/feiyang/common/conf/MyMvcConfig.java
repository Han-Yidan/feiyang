package com.example.feiyang.common.conf;

import org.springframework.boot.system.ApplicationHome;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.File;

/**
 * @author 望舒
 * @date 2022/5/24 19:27
 */

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        ApplicationHome ah = new ApplicationHome(org.apache.tomcat.util.http.fileupload.FileUtils.class);
        String path = ah.getSource().getParentFile().toString();
        System.out.println(path);

        registry.addResourceHandler("/images/**").addResourceLocations("file:" + path + File.separator + "uploadImg" + File.separator);
    }
}
