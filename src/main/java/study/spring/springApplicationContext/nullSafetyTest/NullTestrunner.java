package study.spring.springApplicationContext.nullSafetyTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * NullTestrunner  2019.08.21 Null-Safety 학습
 */
@Component
public class NullTestrunner implements ApplicationRunner {

    @Autowired
    NullSaftyEvent eventService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        eventService.name(null);   // 인텔리제이에서는 Compiler 옵션에서 springframework의 NonNull을 포함시켜주면 방지 멘트 출력된다.
	}

    
}