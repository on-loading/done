package com.yphone.config;

import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by chenhansen on 2018/5/20.
 */


@Configuration
@ComponentScan(basePackages = {"com.yphone"},
        excludeFilters = {
                @ComponentScan.Filter(type = FilterType.ANNOTATION,value = EnableWebMvc.class)}

)
@Import(DruidDataSourceConfig.class)
//@ImportResource(locations = {"classpath:spring/applicationContext.xml"})
public class RootConfig {



    @Bean
    public BeanNameAutoProxyCreator proxycreate(){
        BeanNameAutoProxyCreator proxycreate = new BeanNameAutoProxyCreator();
        proxycreate.setProxyTargetClass(true);
        proxycreate.setBeanNames("*ServiceImpl");
        proxycreate.setInterceptorNames("transactionInterceptor");
        return proxycreate;
    }

//    @Bean
//    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer(){
//        PropertySourcesPlaceholderConfigurer ppc= new PropertySourcesPlaceholderConfigurer();
//        ppc.setLocation(new PathMatchingResourcePatternResolver().getResource("classpath:properties/jdbc.properties"));
//        ppc.setIgnoreUnresolvablePlaceholders(true);
//        return ppc;
//    }

}
