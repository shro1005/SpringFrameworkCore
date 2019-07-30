package study.spring.springApplicationContext.applicationContextTest;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

/**
 * ResourceRoaderTestRunner 2019.07.29  ResourceLoader test (ApplicationContext의 기능)
 *                          2019.07.30  Resource 추상화 공부
 */
@Component
@Order(6)
public class ResourceLoaderTestRunner implements ApplicationRunner {

    @Autowired
    ResourceLoader resourceLoader;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // WebApplicationContext중에 하나가 나올 것이다. (2019.07.30 Resource 추상화 공부)
        System.out.println("Resource추상화 test : resourceLoader's class -> "+ resourceLoader.getClass()); 

        Resource resource = resourceLoader.getResource("classpath:test.txt");
        System.out.println("ResourceLoaderTest : resource exist? -> "+resource.exists());
        System.out.println("ResourceLoaderTest : resource description -> "+resource.getDescription());
        /** resource의 경우 classpath 접두어를 사용했으므로 ClassPathResource로 출력될 것이다. (2019.07.30 추상화 공부)
         *  접두어를 사용하지 않으면 ServletContextResource로 매핑 된다.
         *  하지만 classpath를 사용해서 최대한 명시적인 프로그래밍을 하는 것이 좋다.
         */
        System.out.println("Resource추상화 test : resource's class -> " + resource.getClass());

        Resource resource2 = resourceLoader.getResource("test.txt");   
        /** 이 경우에는 ServletContextResource로 SpringBoot의 내장 Tomcat은 기본적으로 context path 가 설정되있지 않아. (2019.07.30 추상화 공부)
         *  test.txt 파일을 찾을 수 없을 것이다.
         */ 
        System.out.println("Resource추상화 test : resource2 exist? -> "+ resource2.exists());
        System.out.println("ResourceLoaderTest : resource2 description -> "+resource2.getDescription());
        System.out.println("Resource추상화 test : resource2's class -> " + resource2.getClass());
	}

    
}