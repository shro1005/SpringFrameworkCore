package study.spring.springApplicationContext.applicationContextTest;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(2)
@Component
public class RunnerTest implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
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