package study.spring.springApplicationContext.springAOP;

/**
 * proxyPatternEventService     2019.08.15  spring AOP (프록시 AOP ) 공부 - 간략한 프록시 패턴의 AOP 공부
 * subject
 */ 
public interface EventService {
    void createEvent();

    void publishEvent();

    void deleteEvent();
    
}