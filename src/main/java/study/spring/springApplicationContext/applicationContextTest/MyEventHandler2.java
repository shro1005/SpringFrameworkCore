package study.spring.springApplicationContext.applicationContextTest;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

/**
 * MyEventHandler2  2019.07.28. ApplicationEventPublisher 공부
 */
@Component
@EnableAsync
public class MyEventHandler2 {

    @EventListener
    @Async   /** 비동기로 실행  handler는 보통 하나의 쓰레드에서 사용하지만 async로 하면 다른 쓰레드에서 작동시킨다. */
    public void handler(MyEvent myEvent) {
        System.out.println(Thread.currentThread().toString());
        System.out.println("MyEventHandler2 data = " + myEvent.getData());
    }
}