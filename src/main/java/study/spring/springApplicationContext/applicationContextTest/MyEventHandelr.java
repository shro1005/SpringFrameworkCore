package study.spring.springApplicationContext.applicationContextTest;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * MyEventHandelr 2019.07.28 ApplicationEvnetHandler 공부 ~`
 */
@Component
@Order(5)
public class MyEventHandelr /*implements ApplicationListener<MyEvent> -- 역시 Spring 4.2이후로는 구현할 필요없다. 대신에 메소드에 @EvnetLisnter 추가해야한다. */{

    //@Override
    @EventListener
    // @Async
    public void onApplicationEvent(MyEvent event) {
        System.out.println(Thread.currentThread().toString());
        System.out.println("MyEventHandler : 이벤트 받았다. 데이터는 " + event.getData());
    } // EvnetHandelr는 빈에 등록해야한다.

    @EventListener
    // @Async
    public void hanlder(ContextRefreshedEvent event) {
        System.out.println(Thread.currentThread().toString());
        System.out.println("MyEventHandler : ContextRefreshedEvent");
        // ApplicationContext applicationContext = 
    } // EvnetHandelr는 빈에 등록해야한다.

    @EventListener
    // @Async
    public void hanlder(ContextClosedEvent event) {
        System.out.println(Thread.currentThread().toString());
        System.out.println("MyEventHandler : ContextClosedEvent");
        // ApplicationContext applicationContext = 
    } // EvnetHandelr는 빈에 등록해야한다.
    
}