package com.example.constraintlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button;
        button = findViewById(R.id.button);
        EditText editText;
        editText = findViewById(R.id.editText);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentToSecondActivity = new Intent(getApplicationContext(),SecondActivity.class);
                String username = editText.getText().toString();
                intentToSecondActivity.putExtra("username", username);
                startActivity(intentToSecondActivity);
            }
        });
    }
}