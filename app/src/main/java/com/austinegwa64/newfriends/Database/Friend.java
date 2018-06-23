package com.austinegwa64.newfriends.Database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by gwaza on 6/23/2018.
 */

@Entity
public class Friend {


    @PrimaryKey(autoGenerate = true)
    private int id;


    @ColumnInfo(name = "image")
    private int image;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "contact")
    private String contact;

    @ColumnInfo(name = "placemet")
    private String placeMet;

    public Friend(int image, String name, String contact, String placeMet) {
        this.image = image;
        this.name = name;
        this.contact = contact;
        this.placeMet = placeMet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getPlaceMet() {
        return placeMet;
    }

    public void setPlaceMet(String placeMet) {
        this.placeMet = placeMet;
    }
}
