package com.example.projektodolist;

import java.util.ArrayList;
import java.util.List;

public class TaskData {
    private List<TaskObject> listTaskObject;


    public static String[][] data = new String[][]{

    };

    public static ArrayList<TaskObject> getListData(){
        TaskObject taskObject = null;
        ArrayList<TaskObject> list = new ArrayList<>();
        for (int i = 0; i <data.length; i++){
            taskObject = new TaskObject();
            taskObject.setDeadline(data[i][0]);
            taskObject.setName(data[i][1]);
            taskObject.setDesc(data[i][2]);
            list.add(taskObject);
        }
        return list;
    }

//    public static List<Task> getListData(){
//        return this.listTask;
//    }
//    public void setListData(List<Task> listTask){
//        this.listTask = listTask;
//    }
    public static void setData(String[][] data) {
        TaskData.data = data;
    }
}
