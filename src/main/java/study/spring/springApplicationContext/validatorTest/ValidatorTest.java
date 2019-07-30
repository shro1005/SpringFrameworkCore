package study.spring.springApplicationContext.validatorTest;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * ValidatorTest   2019.07.30 Validator 추상화 공부
 */
public class ValidatorTest implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return ValidatorTestEvent.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "notempty", "empty title is not allowed!!");
	}

    
}