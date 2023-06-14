package com.example.projektodolist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TaskViewAdapter extends RecyclerView.Adapter<TaskViewAdapter.TaskViewHolder> {
    private List<TaskObject> listTaskObject;

    public TaskViewAdapter(List<TaskObject> listTaskObject){
        this.listTaskObject = listTaskObject;
    }
    public void setListTask(List<TaskObject> listTaskObject){
        this.listTaskObject = listTaskObject;
    }


    @androidx.annotation.NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@androidx.annotation.NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.task, parent, false);
        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@androidx.annotation.NonNull TaskViewHolder holder, int position) {
        TaskObject taskObject = listTaskObject.get(position);
        holder.tvdeadline.setText(taskObject.getDeadline());
        holder.tvtaskname.setText(taskObject.getName());
        holder.tvtaskdesc.setText(taskObject.getDesc());

    }

    @Override
    public int getItemCount() {
        return listTaskObject.size();
    }


    static class TaskViewHolder extends  RecyclerView.ViewHolder{
        TextView tvdeadline, tvtaskname, tvtaskdesc;

        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);
            tvdeadline = itemView.findViewById(R.id.tvdeadline);
            tvtaskname = itemView.findViewById(R.id.tvtaskname);
            tvtaskdesc = itemView.findViewById(R.id.tvtaskdesc);
        }
    }


}
