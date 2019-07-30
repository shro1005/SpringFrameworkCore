package study.spring.springApplicationContext.validatorTest;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

/**
 * ValidatorTestRunner 2019.07.30 Validator 추상화
 */
@Component
@Order(7)
public class ValidatorTestRunner implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        ValidatorTestEvent event = new ValidatorTestEvent();
        ValidatorTest validator = new ValidatorTest();
        Errors errors = new BeanPropertyBindingResult(event, "event");

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