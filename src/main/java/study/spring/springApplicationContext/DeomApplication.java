package study.spring.springApplicationContext;

import java.util.Arrays;
import java.util.function.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.EnableAsync;

import study.spring.out.OutService;

@SpringBootApplication
//@EnableAsync   // 2019.07.28 EvnetHandler 의 비동기 학습을 위해 추가
public class DeomApplication {

	// @Autowired
	// OutService outService;

	/* 2019.07.28 messageSource 공부 */
	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("classpath:/messages");	
		messageSource.setDefaultEncoding("UTF-8");
		messageSource.setCacheSeconds(3);
		return messageSource;
	}

	public static void main(String[] args) {
		// ApplicationContext context = new
		// ClassPathXmlApplicationContext("application.xml");
		// ApplicationContext context = new
		// AnnotationConfigApplicationContext(AplicationConfig.class);

		// String[] beanDefinitionNames = context.getBeanDefinitionNames();
		// System.out.println(Arrays.toString(beanDefinitionNames));

		// BookService bookService = (BookService) context.getBean("bookService");
		// System.out.println(bookService.bookRepository != null);

		SpringApplication app = new SpringApplication(DeomApplication.class);
		app.addInitializers(new ApplicationContextInitializer<GenericApplicationContext>() {
			// 다른 Application Context를 주입받을 수 있다, functional한 빈 주입이 가능하다.
			// 이렇게functional하게 bean을 주입하면 코드상의 이점이 있고, 성능상의 이점이 있다.(리플랙션이나 시즈라이브러리, 프록시를
			// 사용하지 않기 때문)
			
			@Override
			public void initialize(GenericApplicationContext ctx) {
				// ctx.registerBean(OutService.class);
				ctx.registerBean(ApplicationRunner.class, new Supplier<ApplicationRunner>() {
					@Override
					@Order(1)
					public ApplicationRunner get() {
						return args1 -> System.out.println("DeomApplication (addInitializer): Functional Bean Definition");
					}
				});
			}
		});
		app.run(args);

	}

}
