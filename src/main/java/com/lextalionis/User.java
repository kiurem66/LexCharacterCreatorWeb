package com.lextalionis;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class User implements Serializable, Iterable<Character>{
    private String username;
    private String hashedPassword;
    private ArrayList<Character> characters;
    private Character currentCharacter;

    public User(String username, String hashedPassword){
        this.username = username;
        this.hashedPassword = hashedPassword;
        this.characters = new ArrayList<Character>();
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

    public void addCharacter(Character character){
        if(characters.isEmpty()){
            currentCharacter = character;
        }
        characters.add(character);
    }

    public void removeCharacter(Character character){
        characters.remove(character);
        if(characters.isEmpty()){
            currentCharacter = null;
        }
    }

    public Character getCurrentCharacter() {
        return currentCharacter;
    }

    public void setCurrentCharacter(Character currentCharacter) {
        this.currentCharacter = currentCharacter;
    }

    @Override
    public Iterator<Character> iterator() {
        return characters.iterator();
    }

    
}
