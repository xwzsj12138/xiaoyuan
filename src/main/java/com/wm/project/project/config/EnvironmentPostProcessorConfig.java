package com.wm.project.project.config;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Objects;

@Component
public class EnvironmentPostProcessorConfig implements EnvironmentPostProcessor {

    //外置配置文件的路径
    String configPath = "../application.yml";

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        File file = new File(configPath);
        if (file.exists()){
            FileSystemResource resource = new FileSystemResource(file);
            YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
            yaml.setResources(resource);
            MutablePropertySources propertySources = environment.getPropertySources();
            propertySources.addFirst(new PropertiesPropertySource("Config", Objects.requireNonNull(yaml.getObject())));
        }
    }
}
