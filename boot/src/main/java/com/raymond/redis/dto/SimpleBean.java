package com.raymond.redis.dto;

import java.io.Serializable;

/**
 * Created by Raymond Kwong on 10/12/2016.
 */

public class SimpleBean implements Serializable {
    private static final long serialVersionUID = -2939247125825566726L;
    private int number1;
    private int number2;
    private int number3;

    public SimpleBean() {
    }

    public int getNumber1() {
        return number1;
    }

    public void setNumber1(int number1) {
        this.number1 = number1;
    }

    public int getNumber2() {
        return number2;
    }

    public void setNumber2(int number2) {
        this.number2 = number2;
    }

    public int getNumber3() {
        return number3;
    }

    public void setNumber3(int number3) {
        this.number3 = number3;
    }
}
