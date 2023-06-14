package com.example.projektodolist;

public class TaskObject {
    private String name, desc, deadline;

    public TaskObject(String name, String desc, String deadline){
        this.name = name;
        this.desc = desc;
        this.deadline = deadline;
    }
    public TaskObject(){

    }
    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getDesc() {

        return desc;
    }

    public void setDesc(String desc) {

        this.desc = desc;
    }

    public String getDeadline() {

        return deadline;
    }

    public void setDeadline(String deadline) {

        this.deadline = deadline;
    }


}
