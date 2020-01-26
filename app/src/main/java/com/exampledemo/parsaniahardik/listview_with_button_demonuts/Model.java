package com.exampledemo.parsaniahardik.listview_with_button_demonuts;

/**
 * Created by hardik on 9/1/17.
 */
public class Model {

    private int attended_lecture;
    private String fruit;
    public  Model()
    {
        attended_lecture=0;
        fruit="";
    }

    public Model(int attended_lecture, String fruit) {
        this.attended_lecture = attended_lecture;
        this.fruit = fruit;
    }

    public int getAttended_lecture() {
        return attended_lecture;
    }

    public void setAttended_lecture(int attended_lecture) {
        this.attended_lecture = attended_lecture;
    }

    public String getFruit() {
        return fruit;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }
}
