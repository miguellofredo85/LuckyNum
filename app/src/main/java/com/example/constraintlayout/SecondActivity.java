package com.example.constraintlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ShareActionProvider;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView textView3;
        textView3 = findViewById(R.id.textView3);
        textView3.setText("" + getRandomNum());

        Intent i = getIntent();
        String name = i.getStringExtra("username");

        Toast.makeText(this, "Username: " + name, Toast.LENGTH_LONG).show();


        Button button;
        button = findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shareData(name, getRandomNum());
            }
        });

    }
    public int getRandomNum(){
        return (int) Math.floor(Math.random()*1000);
}
    public void shareData(String name, int randomNum){

        String num = String.valueOf(randomNum);
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_SUBJECT, name);
        i.putExtra(Intent.EXTRA_TEXT, num);
        startActivity(Intent.createChooser(i, "Choose a platform"));
    }
}