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
 */
@Component
@Order(6)
public class ResourceLoaderTestRunner implements ApplicationRunner {

    @Autowired
    ResourceLoader resourceLoader;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Resource resource = resourceLoader.getResource("classpath:test.txt");
        System.out.println("ResourceLoaderTest : "+resource.exists());
        System.out.println("ResourceLoaderTest : "+resource.getDescription());
	}

    
}