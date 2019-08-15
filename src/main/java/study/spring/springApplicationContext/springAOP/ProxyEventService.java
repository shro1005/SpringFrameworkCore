package study.spring.springApplicationContext.springAOP;

import java.lang.annotation.Target;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * ProxyEventService    2019.08.15  spring AOP (프록시 AOP ) 공부 - 간략한 프록시 패턴의 AOP 공부
 *  Target class에 코드 변경없이 새로운 기능들을 추가하기 위해 감쌀 프록시
 */
@Component
@Primary
public class ProxyEventService implements EventService {

    @Autowired
    TargetEventService targetEventService;  // 프록시가 real Subject를 가지고 있고,

    @Override
    public void createEvent() {
        Long begin = System.currentTimeMillis();
        targetEventService.createEvent();           // real subject에게 일을 위힘시켜 대신 처리하고
        System.out.println("ProxyPattern : 걸린시간 " + Long.toString(System.currentTimeMillis() - begin) + "ms") ;   // 부가적인 기능을 가지고 있고
    }

    @Override
    public void publishEvent() {
        Long begin = System.currentTimeMillis();
        targetEventService.publishEvent();
        System.out.println("ProxyPattern : 걸린시간 " + Long.toString(System.currentTimeMillis() - begin) + "ms");
    }

    @Override
    public void deleteEvent() {
        targetEventService.deleteEvent();
    }

    
}