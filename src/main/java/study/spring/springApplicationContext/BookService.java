package study.spring.springApplicationContext;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service  // 
public class BookService {
	
	@Autowired(required = false )  // 옵션을 사용하면서 사용하면, 생성자를 사용한 의존성 주입보다 에러를 줄인다.? (bean자체는 생성되기 때문에 )
	BookRepository bookRepository;
	
//	@Autowired // Bean을 만들 때에도 영향을 준다.
//	public BookService(BookRepository bookRepository) {
//		this.bookRepository = bookRepository;
//	}
	

//	@Autowired // 
	public void setBookRepository(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	@PostConstruct  // bean 인스턴스가 만들어지고, 의존성 주입받은 후 부가적인 작업 실행하는 라이프사이클  =>InitializingBean 을 implement해도 상관없다.
	public void setup() {
		System.out.println(bookRepository.getClass());
	}
	
	
}
