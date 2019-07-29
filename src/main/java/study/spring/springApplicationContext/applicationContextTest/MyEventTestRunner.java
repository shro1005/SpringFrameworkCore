package study.spring.springApplicationContext.applicationContextTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * EventTestRunner 2019.07.28  ApplicationEventPublisher 공부
 */
@Component
@Order(4)
public class MyEventTestRunner implements ApplicationRunner {

    @Autowired
    ApplicationEventPublisher publishEvnet;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        publishEvnet.publishEvent(new MyEvent(this, 100));
	}

    
}