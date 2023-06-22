package com.usmanejaz.hafiz_records;

public class Profile {

    public static int id = 0;
    public String name;
    public int age;
    public String section;

    public Profile() {
        this.id = id + 1;
        this.name = "";
        this.age = 0;
        this.section = "";
    }

    public Profile(String name, int age, String section) {
        this.id = id + 1;
        this.name = name;
        this.age = age;
        this.section = section;
    }


}
