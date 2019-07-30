package study.spring.springApplicationContext.validatorTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * ValidatorTestRunner   2019.07.30 Validator 추상화 공부
 */
@Component
@Order(7)
public class ValidatorTestRunner implements ApplicationRunner {
    @Autowired
    Validator validator;  // SpringBoot 를 사용하면 간단한 검증은 따로 Validator를 만들어서 사용할 필요 없다.
                          // 대신 검증 할 대상 및 검증 방법을 Event에 validation 어노테이션으로 부여할 수 있다.
                          // 복잡한 검증이 필요할때 Validator를 직접 구현해서 사용하면 된다.

    @Override
    public void run(ApplicationArguments args) throws Exception {
        ValidatorTestEvent event = new ValidatorTestEvent();
        // ValidatorTest validator = new ValidatorTest();
        Errors errors = new BeanPropertyBindingResult(event, "event");

        //event setting
        event.setEmail("gdra1964#gmail.com");
        event.setId(-1);

        validator.validate(event, errors);

        System.out.println("ValidatorTest : errors.hasError -> " + errors.hasErrors());

        errors.getAllErrors().forEach(e -> {
            System.out.println("ValidationTest : ======= error code =======");
            for (String errorCode : e.getCodes()) {
                System.out.println("ValidationTest : " + errorCode);
            }
            System.out.println("ValidationTest : errors.DefaultMessage -> " + e.getDefaultMessage());
        });

    }
}