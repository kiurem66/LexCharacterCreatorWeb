package com.lextalionis;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class UserList implements Iterable<User>, Serializable{
    private static UserList instance;
    
    private ArrayList<User> list = new ArrayList<User>();


    private UserList(){
        //copy
    }

    @Override
    public Iterator<User> iterator() {
        return list.iterator();
    }

    public void addUser(User user){
        list.add(user);
        AWSManager.save(user);
    }

    public void removeUser(User user){
        list.remove(user);
        AWSManager.delete(user);
    }

    public static UserList getInstance(){
        if(instance == null){
            instance = new UserList();
        }
        return instance;
    }

    
}
