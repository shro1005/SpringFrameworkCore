package study.spring.springApplicationContext.springAOP;

import org.springframework.stereotype.Service;

/**
 * TargetEventService   2019.08.15  spring AOP (프록시 AOP ) 공부 - 간략한 프록시 패턴의 AOP 공부
 *  Target 객체로 사용할 클래스 (real subject)
 *  실제 기능에 대한 로직을 담고있는 클래스이다.
 */
@Service
public class TargetEventService implements EventService{
    // long begin = System.currentTimeMillis();

    @Override
    public void createEvent() {
        try {
            Thread.sleep(1000); 
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("TargetEvnetService : Created an Event");

        // System.out.println(System.currentTimeMillis() - begin);
    }

    @Override
    public void publishEvent() {
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("TargetEvnetService : Published an Event");

        // System.out.println(System.currentTimeMillis() - begin);
    }

    public void deleteEvent() {
        System.out.println("TargetEvnetService : Delete an Event");
    }
    
}