package com.example.dreamdo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements toDo.FragmentListener {

    private toDo toDoFragment;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (TextView) findViewById(R.id.text1);

        toDoFragment = new toDo();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container1, toDoFragment)
                .commit();


    }

    @Override
    public void OnInputInterface(CharSequence input) {

        text.setText(input);
    }
}
