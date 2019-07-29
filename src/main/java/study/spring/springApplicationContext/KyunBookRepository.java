package study.spring.springApplicationContext;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository 
@Primary // Primary가 있으면 겹치는 레파지토리가 있을때 Primary가 붙은 레파지토리를 읽는다.
public class KyunBookRepository implements BookRepository{

}
