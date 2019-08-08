package study.spring.springApplicationContext.dataBindingTest;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

/**
 * EvnetFormatterTest 2019.08.08 데이터바인딩 (converter, formatter) Formatter 공부
 * 
 * Formatter : Converter가 일반적인것이라면 Formatter는 웹에 특화된 데이터 바인딩 추상화 이다. 웹의 경우 문자열로
 *              받고 이벤트 처리 후 문자열을 messageSource로 전달하는 경우가 많기 때문에 해당 상황만 처리할 수 있다.
 *              역시 쓰레드 세이프해서 비등록이 가능하다.
 *              FormatterRegistry에 등록해야 사용이 가능하다.
 * 
 * FormatterRegistry : 직접사용할 일이 거의 없음. 
 *                     Spring MVC를 사용한다면 Configuration으로 등록한 클래스에 addFormatter() 메소드를 상속받아 등록할 수 있다. (WebConfig.java 참고)
 */
@Component
public class EventFormatterTest implements Formatter<BindingTestEvent> {
    @Autowired
    MessageSource messageSource;

    @Override
    public String print(BindingTestEvent object, Locale locale) {
        messageSource.getMessage("example", new String[] { "kyun" }, locale);
        return Integer.toString(object.getId());
    }

    @Override
	public BindingTestEvent parse(String text, Locale locale) throws ParseException {
		return new BindingTestEvent(Integer.parseInt(text));
	}

    
}