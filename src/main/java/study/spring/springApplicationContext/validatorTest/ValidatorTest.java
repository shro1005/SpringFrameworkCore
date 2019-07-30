package study.spring.springApplicationContext.validatorTest;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * ValidatorTest
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