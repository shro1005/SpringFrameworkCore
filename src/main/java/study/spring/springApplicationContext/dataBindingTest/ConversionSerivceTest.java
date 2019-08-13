package study.spring.springApplicationContext.dataBindingTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

/**
 * ConverstionSerivceTest   2019.08.08  데이터바인딩 (ConversionService 공부)
 */
@Component
@Order(8)
public class ConversionSerivceTest implements ApplicationRunner {

    @Autowired
    ConversionService conversionService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("ConversionServiceTest : "+conversionService.getClass().toString());
        // System.out.println(conversionService);
	}

    
}