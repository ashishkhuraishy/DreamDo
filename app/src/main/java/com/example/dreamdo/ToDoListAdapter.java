package com.example.dreamdo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ToDoListAdapter extends RecyclerView.Adapter<ToDoListAdapter.ToDoListViewHolder> {

    private ArrayList<ToDoList> toDoLists;

    public class ToDoListViewHolder extends RecyclerView.ViewHolder {

        public TextView toDo;
        public CheckBox checkBox;

        public ToDoListViewHolder(@NonNull View itemView) {
            super(itemView);
            toDo = (itemView).findViewById(R.id.todoTextView);
            checkBox = itemView.findViewById(R.id.checkBox);
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
    public void onBindViewHolder(@NonNull ToDoListViewHolder holder, final int position) {

        ToDoList currentItem = toDoLists.get(position);
        holder.toDo.setText(currentItem.getToDoList());
        holder.checkBox.setChecked(false);

        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    toDoLists.remove(position);
                    notifyDataSetChanged();
                    notifyItemRemoved(position);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return toDoLists.size();
    }
}
