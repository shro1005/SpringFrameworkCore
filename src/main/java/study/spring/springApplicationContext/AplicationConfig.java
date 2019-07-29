package study.spring.springApplicationContext;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = DeomApplication.class)
public class AplicationConfig {

    // @Bean
    // public BookRepository bookRepository() {
    // return new BookRepository();
    // }

    // @Bean
    // public BookService bookService() {
    // BookService bookService = new BookService();
    // bookService.setBookRepository(bookRepository());
    // return bookService;
    // }
}
