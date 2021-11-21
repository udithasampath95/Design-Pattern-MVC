package com.example.mvctest.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class UserResponse extends Observable implements Serializable {
    @SerializedName("results")
    ArrayList<Results> userList;

    private List<Integer> list;

    public UserResponse(){
        list=new ArrayList<Integer>();
        list.add(0);
        list.add(0);
        list.add(0);
    }

    public ArrayList<Results> getUserList() {
        return userList;
    }

    public void setUserList(ArrayList<Results> userList) {
        this.userList = userList;
    }

    public int getValueAtIndex(final int the_index) throws IndexOutOfBoundsException{
        return list.get(the_index);
    }
    public void setValueAtIndex(final int the_index) throws IndexOutOfBoundsException{
        list.set(the_index,list.get(the_index) + 1);
        setChanged();
        notifyObservers();
    }



}
