package study.spring.springApplicationContext.springAOP;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * LogPerf      2019.08.21 Spring AOP 학습 - pointcut을 지정해주기 위한 어노테이션 생성
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.CLASS)
public @interface LogPerf {
}