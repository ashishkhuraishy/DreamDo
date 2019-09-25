package com.example.dreamdo;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity implements toDo.FragmentListener {

    private TextView text;
    private FloatingActionButton addListButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (TextView) findViewById(R.id.text1);
        addListButton = (FloatingActionButton) findViewById(R.id.fab);

        addListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toDo bottomSheetToDo = new toDo();
                bottomSheetToDo.show(getSupportFragmentManager(), "New ToDo");
            }
        });


    }

    @Override
    public void OnInputInterface(CharSequence input) {

        text.setText(input);
    }
}
