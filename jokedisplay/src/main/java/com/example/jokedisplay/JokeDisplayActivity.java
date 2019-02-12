package com.example.jokedisplay;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class JokeDisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_display);

        String jokeToDisplay = getIntent().getStringExtra("joke_string");

        TextView textView = findViewById(R.id.joke_display_text_view);
        textView.setText(jokeToDisplay);
    }
}
