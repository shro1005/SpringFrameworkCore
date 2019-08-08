package study.spring.springApplicationContext.dataBindingTest;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * EventConverterTest   2019.08.08  DataBinding (데이터 바인딩) - Converter, Formatter 공부
 * 
 * Converter : PropertyEditer를 대신해서 사용할 수 있다.
 *             String을 Target(object)로 변경해줄 수 있는 PropertyEditer보다 더 일반적인 개념으로 Object를 Object로 변경해준다.
 *             PropertyEditer의 특징인 상태정보를 가지고 있다는 단점을 없앴다. (쓰래드 세이프하다! - 빈 등록가능 /  ConverterRegistry에 등록해야 사용가능)
 * 
 * ConverterRegistry : 직접사용할 일이 거의 없음. 
 *                     Spring MVC를 사용한다면 Configuration으로 등록한 클래스에 addFormatter() 메소드를 상속받아 등록할 수 있다. (WebConfig.java 참고)
 * 
 * ConversionService : ConverterRegistry, FormatterRegistry을 다시 등록하여 실질적인 데이터 변환을 하는 클래스이다. (DefaultConversionService 참고)
 */
public class EventConverterTest {

    @Component
    public static class  StringToEventConverter implements Converter<String, BindingTestEvent>{

        @Override
        public BindingTestEvent convert(String source) {    // 실제로 데이터 변환은 ConversionService(DataBinder 역할 대신) 가 작동해서 변환한다.
            return new BindingTestEvent(Integer.parseInt(source));
        }
        
    }

    // @Component
    public static class EventToStringConverter implements Converter<BindingTestEvent, String> {

        @Override
        public String convert(BindingTestEvent source) {
            return Integer.toString(source.getId());
        }
        
    }
    
}