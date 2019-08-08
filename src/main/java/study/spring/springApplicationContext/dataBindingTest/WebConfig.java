package study.spring.springApplicationContext.dataBindingTest;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * WebConfig  2019.08.08 데이터바인딩 (Converter 테스트를 위한 WebMvcConfigure)
 */
// @Configuration
public class WebConfig implements WebMvcConfigurer{

    @Override
    public void addFormatters(FormatterRegistry registry) {
        // registry.addConverter(new EventConverterTest.StringToEventConverter());
        registry.addFormatter(new EventFormatterTest());
    }
    
}