package study.spring.springApplicationContext.springAOP;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * PerfAspect    2019.08.21 Spring AOP 학습 (AOP 어노테이션(@Aspect, ,@Around, @Pointcut 등)을 이용한 Spring AOP 학습)
 */

 @Component
 @Aspect   // Aspect : 하나의 모듈 (다양하나 클래스에서 공통적으로 사용하는 하나의 기능을 나타냄)
public class PerfAspect {

    //@Around("execution(* study.spring.springApplicationContext..*.EventService.*(..))")  
    // Aspect에서 해야할 일들 (기능 구현한 소스) , Value로 pointcut을 직접 또는 이름을 줄 수 있고, 위와 같이 표현식을 사용할 수 있디
    
    // @Around("bean(targetEventService)")
    // 빈을 등록할 수도 있다.

    @Around("@annotation(LogPerf)")  
    //직접만든 어노테이션을 이용할 수 있다. 어노테이션을 만들어 사용하면 원라는 메소드에만 aspect으로 감쌀 수 있다.
    public Object logPerf(ProceedingJoinPoint pjp) throws Throwable {
        
        long begin = System.currentTimeMillis();
        Object retVal = pjp.proceed();  // 감쌀 메소드 호출하는 부분
        System.out.print("Aspect : time check -> ");
        System.out.println(System.currentTimeMillis() - begin);
        return retVal;
        
    }

    @Before("@annotation(LogPerf)")  //Around 이전에 실행할 소스를 추가할 수 있다.
    public void beforeLogging() {
        System.out.println("Aspect : ======== before log -> aspect start ========");
    }

    @AfterReturning("@annotation(LogPerf)")  // Around 적용된 메소드의 리턴이 끝난후 실행할 소스를 추가할 수 있다.
    public void afterLogging() {
        System.out.println("Aspect : ======== after log -> aspect end ========");
    }
    
}