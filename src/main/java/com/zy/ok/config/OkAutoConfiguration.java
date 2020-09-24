package com.zy.ok.config;

import com.zy.ok.properties.OkProperties;
import com.zy.ok.service.OkService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass({OkService.class})
@EnableConfigurationProperties(OkProperties.class)
//当配置文件中example.service.enabled=true时
@ConditionalOnProperty(prefix = "ok",name = "isopen",havingValue = "true")
public class OkAutoConfiguration {

    private final OkProperties okProperties;

    public OkAutoConfiguration(OkProperties okProperties) {
        this.okProperties = okProperties;
    }

    @Bean
    //当容器中没有这个Bean的时候才创建这个Bean
    @ConditionalOnMissingBean(OkService.class)
    public OkService okService(){
        OkService okService = new OkService(okProperties.getDescribe());
        return okService;
    }
}
