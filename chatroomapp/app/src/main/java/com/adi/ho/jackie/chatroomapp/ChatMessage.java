package com.adi.ho.jackie.chatroomapp;

/**
 * Created by JHADI on 3/23/16.
 */
public class ChatMessage {

    public String color;
    public String name;
    public String text;

    public  ChatMessage(){}

    public ChatMessage(String name, String color, String text){
        this.name = name;
        this.color = color;
        this.text = text;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
