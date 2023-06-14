package com.example.projektodolist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;


public class CardViewTaskAdapter extends RecyclerView.Adapter<CardViewTaskAdapter.CardViewViewHolder>{
    private ArrayList<TaskObject> taskObjectList;
    private Context context;

    public CardViewTaskAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<TaskObject> getTaskList() {
        return taskObjectList;
    }

    public void setTaskList(ArrayList<TaskObject> taskObjectList) {
        this.taskObjectList = taskObjectList;
    }

    @Override
    public CardViewViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.task, parent, false);
        CardViewViewHolder viewHolder = new CardViewViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CardViewViewHolder holder, int position) {
        TaskObject c = getTaskList().get(position);
        holder.deadline.setText(c.getDeadline());
        holder.name.setText(c.getName());
        holder.desc.setText(c.getDesc());
    }
    @Override
    public int getItemCount() {
        return getTaskList().size();
    }

    public class CardViewViewHolder extends RecyclerView.ViewHolder {
        TextView name, deadline, desc;

        public CardViewViewHolder(View itemView) {
            super(itemView);
            deadline = (TextView)itemView.findViewById(R.id.tvdeadline);
            name = (TextView)itemView.findViewById(R.id.tvtaskname);
            desc = (TextView)itemView.findViewById(R.id.tvtaskdesc);
        }
    }
}
