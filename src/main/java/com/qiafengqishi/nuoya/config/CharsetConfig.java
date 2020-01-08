package com.qiafengqishi.nuoya.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import java.nio.charset.Charset;
import java.util.List;

/**
 * https://blog.csdn.net/qq_39654841/article/details/81156695
 */
@Configuration
public class CharsetConfig extends WebMvcConfigurationSupport {

//    /** 请求url忽略大小写 */
//    @Override
//    public void configurePathMatch(PathMatchConfigurer configurer) {
//        AntPathMatcher pathMatcher = new AntPathMatcher();
//        pathMatcher.setCaseSensitive(false);
//        configurer.setPathMatcher(pathMatcher);
//    }


    /** utf-8编码 */
    @Bean
    public HttpMessageConverter<String> responseBodyConverter() {
        return new StringHttpMessageConverter(Charset.forName("UTF-8"));
    }

    /** 关键代码 */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(responseBodyConverter());
        // 加载默认转换器
        addDefaultHttpMessageConverters(converters);
    }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.favorPathExtension(false);
    }
}
