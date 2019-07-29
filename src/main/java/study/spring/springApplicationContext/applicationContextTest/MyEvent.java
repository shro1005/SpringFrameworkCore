package study.spring.springApplicationContext.applicationContextTest;

import org.springframework.context.ApplicationEvent;

/**
 * MyEvent  2019.07.28 ApplicationEventpublisher 공부
 */
public class MyEvent /*extends ApplicationEvent    -- Spring 4.2 버전이후 ApplicationEvnet를 상속 받을 필요 없어졌다.*/{  
    // Event는 빈으로 등록하는 것이 아니다. (EventHandler는 빈으로 등록해야함.)

    private int data;

    private Object source;

    public MyEvent(Object source, int data) {
        this.source = source;
        this.data = data;
    }

    public Object getSource() {
        return source;
    }
    
    public int getData() {
        return data;
    }
}