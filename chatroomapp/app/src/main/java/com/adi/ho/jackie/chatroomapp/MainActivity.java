package com.adi.ho.jackie.chatroomapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.firebase.client.Firebase;

public class MainActivity extends AppCompatActivity {

    EditText loginEdit;
    Button loginButton;
    Spinner chatroomSelect;
    String color = "blue";
Button blueButton;
    Button redButton;
    Button greenButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginEdit = (EditText) findViewById(R.id.loginname);
        loginButton = (Button) findViewById(R.id.login);
        chatroomSelect = (Spinner)findViewById(R.id.selectchatroom);
        blueButton = (Button)findViewById(R.id.bluebutton);
        redButton = (Button)findViewById(R.id.redbutton);
        greenButton = (Button)findViewById(R.id.greenbutton);


        blueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                color = "blue";
            }
        });
        redButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                color = "red";
            }
        });
        greenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                color = "green";
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (loginEdit.getText().toString().trim() != null && loginEdit.getText().toString().trim() != "") {
                    Intent loginIntent = new Intent(MainActivity.this, ChatActivity.class);
                    loginIntent.putExtra("NAME", loginEdit.getText().toString());
                    loginIntent.putExtra("COLOR", color);
                    startActivity(loginIntent);
                }
            }
        });

    }
}
