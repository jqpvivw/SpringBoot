package com.jqpv.boot.config;

import ch.qos.logback.classic.net.SocketNode;
import com.jqpv.boot.bean.Pet;
import com.jqpv.boot.converter.JqpvMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.util.StringUtils;
import org.springframework.web.accept.HeaderContentNegotiationStrategy;
import org.springframework.web.accept.ParameterContentNegotiationStrategy;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName:WedConfig
 * Package:com.jqpv.boot.config
 * Description:
 *
 * @Author:梁杰圣
 * @Create:2023/2/3 - 16:35
 * @Version:v1.0
 */
@Configuration(proxyBeanMethods = false)
public class WedConfig /**implements WebMvcConfigurer*/ {

    //自定义filter

//    @Bean
//    public HiddenHttpMethodFilter hiddenHttpMethodFilter(){
//        HiddenHttpMethodFilter methodFilter = new HiddenHttpMethodFilter();
//        methodFilter.setMethodParam("_v");
//        return methodFilter;
//    }



    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void configurePathMatch(PathMatchConfigurer configurer) {
                UrlPathHelper urlPathHelper =new UrlPathHelper();

                    urlPathHelper.setRemoveSemicolonContent(false);

                    configurer.setUrlPathHelper(urlPathHelper);
            }

            @Override
            public void addFormatters(FormatterRegistry registry) {
                registry.addConverter(new Converter<String, Pet>() {

                    @Override
                    public Pet convert(String source) {
                        if (!StringUtils.isEmpty(source)){
                            Pet pet = new Pet();
                            String[] split = source.split(",");
                            pet.setName(split[0]);
                             pet.setAge(String.valueOf(Integer.parseInt(split[1])));
                            return pet;
                        }
                        return null;
                    }
                });
            }

            @Override
            public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
                converters.add(new JqpvMessageConverter());
            }

            @Override
            public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
                Map<String, MediaType> mediaTypeMap=new HashMap<>();

                mediaTypeMap.put("json",MediaType.APPLICATION_JSON);

                mediaTypeMap.put("xml",MediaType.APPLICATION_XML);

                mediaTypeMap.put("jqpv",MediaType.parseMediaType("application/x-jqpv"));

                ParameterContentNegotiationStrategy parameterStrategy = new ParameterContentNegotiationStrategy(mediaTypeMap);

                HeaderContentNegotiationStrategy headerStrategy = new HeaderContentNegotiationStrategy();

                configurer.strategies(Arrays.asList(parameterStrategy,headerStrategy));
            }
        };
    }

//    @Override
//    public void configurePathMatch(PathMatchConfigurer configurer) {
//        UrlPathHelper urlPathHelper =new UrlPathHelper();
//        urlPathHelper.setRemoveSemicolonContent(false);
//        configurer.setUrlPathHelper(urlPathHelper);
//    }
}
