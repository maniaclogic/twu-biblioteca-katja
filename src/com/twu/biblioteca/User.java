package com.twu.biblioteca;

import java.security.PublicKey;
import java.util.ArrayList;

public class User {
    private String idNum;
    private String psswd;
    private String name;
    private String tel;
    private String email;
    private ArrayList<String> checkedOutMedia = new ArrayList<String>();
    public static ArrayList<User> userList = new ArrayList<User>();

    User(String idNum, String psswd, String name, String tel, String email) {
        if (idNum.length() == 8 && idNum.contains("-")) { this.idNum = idNum; }
        if (psswd.length() > 3) { this.psswd = psswd; }
        if (tel.length() > 8) { this.tel = tel; }
        if (email.contains("@") && email.contains(".")) { this.email = email; }
        this.name = name;
    }

    public static User createUser(String idNum, String psswd, String name, String tel, String email) {
        User user = new User(idNum, psswd, name, tel, email);
        userList.add(user);
        return user;
    }

    public String getIdNum() { return this.idNum; }

    public String getPsswd() { return this.psswd; }

    public String getName() { return this.name; }

    public String getNumber() { return this.tel; }

    public String getEmail() { return this.email; }

    public ArrayList<String> getCheckedOutMedia() { return this.checkedOutMedia; }

    public static ArrayList<User> getUserList() { return userList; }

    public String toString() { return this.idNum + ";" + this.psswd; }

    public void checkedOut(Media media) {
        checkedOutMedia.add(media.toString());
    }

    String getUserContacts() {
        return "ID: "+this.getIdNum()+ ", Name: "+this.getName()+", Tel: "+this.getNumber()+", Email: "+this.getEmail();
    }

}
