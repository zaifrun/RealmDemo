package org.webdevelopment.realmdemo;

import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

/**
 * Created by makn on 08-05-2017.
 */

public class Student extends RealmObject {

        @PrimaryKey
        private long id;
        @Required
        private String name;
        @Required
        private Date birthday;
        @Required
        private String email;
        // getters and setters


    @Override
    public String toString() {
        return id+": "+name+" , "+email+ ", "+birthday;
    }

    public Student() {}

    public Student(long id, String name, Date birthday, String email)
    {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
