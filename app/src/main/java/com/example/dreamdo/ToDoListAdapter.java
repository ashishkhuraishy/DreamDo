package com.example.dreamdo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ToDoListAdapter extends RecyclerView.Adapter<ToDoListAdapter.ToDoListViewHolder> {

    private ArrayList<ToDoList> toDoLists;

    public class ToDoListViewHolder extends RecyclerView.ViewHolder {

        public TextView toDo;

        public ToDoListViewHolder(@NonNull View itemView) {
            super(itemView);
            toDo = (itemView).findViewById(R.id.todoTextView);
        }
    }

    public ToDoListAdapter(ArrayList<ToDoList> _toDoLists) {
        toDoLists = _toDoLists;
    }

    @NonNull
    @Override
    public ToDoListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_todo_list, parent, false);
        ToDoListViewHolder viewHolder = new ToDoListViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ToDoListViewHolder holder, int position) {

        ToDoList currentItem = toDoLists.get(position);

        holder.toDo.setText(currentItem.getToDoList());

    }

    @Override
    public int getItemCount() {
        return toDoLists.size();
    }
}
