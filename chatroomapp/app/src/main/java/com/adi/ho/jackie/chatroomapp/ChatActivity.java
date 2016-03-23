package com.adi.ho.jackie.chatroomapp;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.client.Firebase;
import com.firebase.ui.FirebaseListAdapter;

public class ChatActivity extends AppCompatActivity {

    Firebase mRootReference;
    String userName;
    String color;
    ListView chatList;
    EditText chatEditText;
    Button submitButton;
    FirebaseListAdapter<ChatMessage> mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        mRootReference = new Firebase("https://blinding-inferno-4100.firebaseio.com/");

        final Firebase chatRoom1 = mRootReference.child("chatroom1");
        final Firebase chatMessages = chatRoom1.child("messages");

        chatList = (ListView)findViewById(R.id.chatlist);
        chatEditText = (EditText)findViewById(R.id.chat_edittext);
        submitButton = (Button)findViewById(R.id.submit);

        userName = getIntent().getStringExtra("NAME");
        color = getIntent().getStringExtra("COLOR");

        mAdapter = new FirebaseListAdapter<ChatMessage>(this,ChatMessage.class,R.layout.chat_list_layout,chatRoom1) {
            @Override
            protected void populateView(View view, ChatMessage s, int i) {
                TextView userName = (TextView)view.findViewById(R.id.user_name_text);
                TextView text = (TextView)view.findViewById(R.id.chat_text);
                String userColor = s.getColor();
                userName.setText(s.getName());
                text.setText(s.getText());
                switch (userColor){
                    case "blue": userName.setTextColor(Color.BLUE);break;
                    case "red": userName.setTextColor(Color.RED);break;
                    case "green": userName.setTextColor(Color.GREEN);break;
                }
            }
        };

        FirebaseListAdapter<ChatMessage> chatAdapter = new FirebaseListAdapter<ChatMessage>(ChatActivity.this,ChatMessage.class,android.R.layout.simple_list_item_2,chatRoom1) {
            @Override
            protected void populateView(View view, ChatMessage chatMessage, int i) {
                TextView userName = (TextView) view.findViewById(android.R.id.text1);
                TextView text = (TextView) view.findViewById(android.R.id.text2);
                String userColor = chatMessage.getColor();
                userName.setText(chatMessage.getName());
                text.setText(chatMessage.getText());
                switch (userColor) {
                    case "blue":
                        userName.setTextColor(Color.BLUE);
                        break;
                    case "red":
                        userName.setTextColor(Color.RED);
                        break;
                    case "green":
                        userName.setTextColor(Color.GREEN);
                        break;
                }
            }
        };

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chatRoom1.push().setValue(new ChatMessage(userName,color,chatEditText.getText().toString()));
            }
        });
        chatList.setAdapter(mAdapter);


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mAdapter.cleanup();
    }
}
