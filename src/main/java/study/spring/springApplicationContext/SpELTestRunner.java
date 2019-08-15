package study.spring.springApplicationContext;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.stereotype.Component;

/**
 * SpELTestRunner   2019.08.13  Spring EL 표현식 공부
 * 
 * 기존 EL 표현식과 비슷한 기능을 하며, 메소드 호출을 가능하며 문자열 템플릿 제공이 가능하다.
 * SpEL은 모든 Spring Project 전반에 걸쳐 사용될 수 있다.
 */
@Component
@Order(9)
public class SpELTestRunner implements ApplicationRunner {

    @Value("#{1 + 1}")   //#사용 : 이렇게 Value 어노테이션에 #과 함께 입력한 식들을 EL표현식으로 파싱해서 결과값을 해당 변수에 넣어준다.
    int value;           // #{표현식}

    @Value("#{'Hello~!'}")
    String greeting;

    @Value("#{1 eq 1}")
    boolean isTrueOrFalse;

    @Value("${my.value}")   // $사용 : 프로퍼티 참고하는 방법 - 프로퍼티에 등록한 값들을 가져올 수 있다.
    int myValue;            // ${프로퍼티}

    @Value("#{${my.value} / 2}")  // 표현식 안에는 프로퍼티를 사용할 수 있다. 반대는 x
    int myValue2;

    // 그 이외에도 bean에 등록된 객체의 변수 값을 가져올수도 있고, 함수를 호출할 수도 있다.

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("SpELTest : ============================");
        System.out.println("SpELTest : value -> " + value);
        System.out.println("SpELTest : greeting -> " + greeting);
        System.out.println("SpELTest : isTrueOrFalse -> " + isTrueOrFalse);
        System.out.println("SpELTest : myValue -> " + myValue +  "  (프로퍼티 값 불러옴 application.properties 참고 ) ");
        System.out.println("SpELTest : myValue2 -> " + myValue2 +  "  (표현식 안에 프로퍼티 사용 가능) ");

        // ExpressionParser 사용
        ExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser.parseExpression("1 + 100");
        int ExpressionParserValue = expression.getValue(Integer.class);
        System.out.println("SpELTest : ExpressionParserValue -> " + ExpressionParserValue);
	}

    
}