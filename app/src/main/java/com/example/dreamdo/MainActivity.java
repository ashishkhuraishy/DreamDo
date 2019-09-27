package com.example.dreamdo;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ToDoBottomSheetFragment.FragmentListener {

    private TextView text;
    private FloatingActionButton addListButton;
    private ArrayList<ToDoList> toDoLists;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    SharedPreferences sherf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadData();
        saveData();

        toDoLists = new ArrayList<>();

        text = (TextView) findViewById(R.id.text1);
        addListButton = (FloatingActionButton) findViewById(R.id.fab);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        addListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToDoBottomSheetFragment bottomSheetToDoBottomSheetFragment = new ToDoBottomSheetFragment();
                bottomSheetToDoBottomSheetFragment.show(getSupportFragmentManager(), "New ToDo");
            }
        });

        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ToDoListAdapter(toDoLists);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setLayoutManager(mLayoutManager);



    }

    private void loadData() {



    }

    private void saveData() {

        sherf =  PreferenceManager.getDefaultSharedPreferences(this.getApplicationContext());
        SharedPreferences.Editor prefEditor = sherf.edit();


    }

    /**
     * Returns the Input value from the fragment
     **/

    @Override
    public void OnInputInterface(CharSequence input) {
        toDoLists.add(new ToDoList(input));
        mAdapter.notifyDataSetChanged();
        mAdapter.notifyItemChanged(mAdapter.getItemCount());
    }
}
