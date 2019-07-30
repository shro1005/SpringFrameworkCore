package study.spring.springApplicationContext.validatorTest;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

/**
 * validatorTestEvent   2019.07.30 Validator 추상화 공부
 */
public class ValidatorTestEvent {
    @Min(0)
    @Max(1000)
    int id;

    @NotEmpty
    String title;

    @Email
    String email;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }
    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }
    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }
    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }
    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
}