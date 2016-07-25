package com.zdatainc;

import java.util.List;

/**
 * Created by demo on 7/20/16.
 */
public class Predictions {
    private Integer id;
    private Double age, gender, target;

    public Predictions(Integer id, Double age, Double gender, Double target) {
        this.id = id;
        this.age = age;
        this.gender = gender;
        this.target = target;
    }

    @Override
    public String toString() {
        return String.format("Predictions[id=%d, age='%s', gender='%s', target='%s']", id, age, gender, target);
    }
}
