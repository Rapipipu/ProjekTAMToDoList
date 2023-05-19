package com.example.projektodolist;

import java.util.ArrayList;

public class TaskData {
    public static String[][] data = new String[][]{
            {"H-1", "ML Prak", "Proyek Akhir"},
            {"H-3", "ADSI Prak", "Proyek Akhir"},
            {"H-5", "TI Prak", "Proyek Akhir"},
    };
    public static ArrayList<Task> getListData(){
        Task task = null;
        ArrayList<Task> list = new ArrayList<>();
        for (int i = 0; i <data.length; i++){
            task = new Task();
            task.setDeadline(data[i][0]);
            task.setName(data[i][1]);
            task.setDesc(data[i][2]);
            list.add(task);
        }
        return list;
    }
}
