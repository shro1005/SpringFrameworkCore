package study.spring.springApplicationContext.dataBindingTest;

/**
 * BindingTestEvent   2019.07.30. 데이터바인딩 (PropertyEditor) 공부
 */
public class BindingTestEvent {

    int id;
    String title;

    public BindingTestEvent(int parseInt) {
        this.id = parseInt;
	}
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
    @Override
    public String toString() {
        return "Event{ id = " + id + ", title = '" + title + "'}";
    }
}