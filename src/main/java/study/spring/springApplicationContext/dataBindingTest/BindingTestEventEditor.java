package study.spring.springApplicationContext.dataBindingTest;

import java.beans.PropertyEditorSupport;

/**
 * BindingTestEventEditor   2019.07.30  데이터바인딩 (EventEditor) 공부
 * 
 * PropertyEditor가 가지는 Value는 서로다른 Thread에 공유된다. (즉 Stateful하다)
 * 즉 Thread Safe하지 않기 때문에 절대로 Bean으로 등록해서 사용해선 안된다.
 * 만약 Bean으로 등록하여 사용하면 1번 사용자가 2번 사용자의 정보를 변경할 수 도 있고, 2번 사용자가  4번 사용자의 정보를 변경할 수 있다.
 * (Thread scorp한 Bean으로 사용하는 것이 그나마 괜찮긴 하지만  Bean으로 등록하지 않는것이 원칙)
 * 보통 Bean으로 등록하는 것 대신 Controller에  @InitBinder 등록하여 사용한다.
 */

public class BindingTestEventEditor extends PropertyEditorSupport{
    
    @Override
    public String getAsText() {
        BindingTestEvent event = (BindingTestEvent)getValue();
        return Integer.toString(event.getId());
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        setValue(new BindingTestEvent(Integer.parseInt(text)));
    }
}