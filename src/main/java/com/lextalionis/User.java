package com.lextalionis;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class User implements Serializable, Iterable<Character>{
    private String username;
    private String hashedPassword;
    private ArrayList<Character> charList;

    public User(String username, String hashedPassword){
        this.username = username;
        this.hashedPassword = hashedPassword;
        charList = new ArrayList<Character>();
    }

    public String getUsername() {
        return username;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    @Override
    public Iterator<Character> iterator() {
        return charList.iterator();
    }

    public void addChara(Character character){
        charList.add(character);
    }

    public void delChara(Character character){
        charList.remove(character);
    }

    public boolean hasNoChara(){
        return charList.isEmpty();
    }
    
}
