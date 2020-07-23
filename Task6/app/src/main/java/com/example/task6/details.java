package com.example.task6;

public class details {
    int id;
    byte [] image;

    details(){ }

    details(int id, byte[] image){
        this.id = id;
        this.image = image;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
