package study.spring.springApplicationContext.nullSafetyTest;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

/**
 * NullSaftyEvent       2019.08.21 Null-Safety 학습
 * Null-Safety는 spring framework 5에서 처음 추가된 기능으로, 컴파일 타임에 널포인트 에러를 없애기 위해 사용한다. 
 */
@Service
public class NullSaftyEvent {

    @NonNull  // 메소드에 @NonNull을 적용하면 return되는 변수가 Null 이면 에러 메세지를 띄운다.
    public String name(@NonNull String name) {  // @NonNull 어노테이션을 사용해 받는 변수가 널이면 에러 메세지를 띄운다..
        return name;
    }
    
}