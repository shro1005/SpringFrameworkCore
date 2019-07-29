package study.spring.springApplicationContext.applicationContextTest;

import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.MessageSource;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * MessageSourceTest  2019.07.28 MessageSource 공부
 */
@Component
@Order(1)
public class MessageSourceTest implements ApplicationRunner {

    @Autowired
    MessageSource messageSource;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        /*
         * SpringBoot프로젝트의 경우 messages로 시작하는 properties를 만들면 알아서 messageSource로 읽을 수 있다.
         */
        // System.out.println(messageSource.getClass());
        // while (true) {
            System.out.println(messageSource.getMessage("greeting", new String[] { "kyun" }, Locale.KOREA));
            System.out.println(messageSource.getMessage("greeting", new String[] { "kyun" }, Locale.getDefault()));
            Thread.sleep(1000);
        // }s
    }

}