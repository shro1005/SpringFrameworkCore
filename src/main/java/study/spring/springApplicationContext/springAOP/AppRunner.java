package study.spring.springApplicationContext.springAOP;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * AppRunner    2019.08.15  spring AOP (프록시 AOP) 공부 - 간략한 프록시 패턴의 AOP 공부
 * 
 */
@Component
@Order(10)
public class AppRunner implements ApplicationRunner{

    @Autowired
    EventService eventService;   //클라이언트는 EventService를 가지고 있지만, 프록시를 Primary로 설정했기 때문에 프록시를 불러오게 된다.

    @Override
    public void run(ApplicationArguments args) throws Exception {
        eventService.createEvent();
        eventService.publishEvent();
        eventService.deleteEvent();
	}
    
}