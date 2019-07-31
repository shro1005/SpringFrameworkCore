package study.spring.springApplicationContext.dataBindingTest;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * BindingTestEventController  2019.07.30. 데이터바인딩 (PropertyEditor) 공부
 */
@RestController
public class BindingTestEventController {

    @InitBinder
    public void init(WebDataBinder webDataBinder) {   // EventEditor를 등록하는 방법
        webDataBinder.registerCustomEditor(BindingTestEvent.class, new BindingTestEventEditor());
    }

    @GetMapping("event/{event}")
    public String getEvent(@PathVariable BindingTestEvent event) {
        System.out.println("BindingTest : event -> " + event);
        return Integer.toString(event.getId());
    }
}