package com.paladin;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by meghandow on 3/25/16.
 */
@Entity
@Table
public class Student {

    @Id
    @GeneratedValue
    private Integer id;

    private String firstName;
    private Integer age;

    public Student() {};

    public Student(String firstName, Integer age) {
        this.firstName = firstName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}