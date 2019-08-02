package study.spring.springApplicationContext.applicationContextTest;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Order(2)
@Component
public class RunnerTest implements ApplicationRunner {
    // @Autowired
    // ConfigurableApplicationContext ctx;       // 2019.07.31  ApplicationContext - Environmet (프로파일 ) 공부

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // ConfigurableEnvironment environment = ctx.getEnvironment();
        // environment.setActiveProfiles("dev");       
        // System.out.println(Arrays.toString(environment.getActiveProfiles()));
        // String PropertyValue = environment.getProperty("key");      // 2019.07.31  ApplicationContext - Environmet (프로파일 ) 공부
        System.out.println("RunnerTest : ============ApplicationRunner");
    }
}

@Order(3)
@Component
class TestApplicationRunner2 implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("RunnerTest : ============ApplicationRunner2");
    }
}

@Order(2)
@Component
class TestCommandLineRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("RunnerTest : ============CommandLineRunner1");
    }
}