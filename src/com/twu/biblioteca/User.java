package com.twu.biblioteca;

import java.util.ArrayList;

public class User {
    private String idNum;
    private String psswd;
    private ArrayList<String> checkedOutMedia = new ArrayList<String>();
    public static ArrayList<User> userList = new ArrayList<User>();

    User(String idNum, String psswd) {
        if (idNum.length() == 8 && idNum.contains("-")) {
            this.idNum = idNum;
        }
        if (psswd.length() > 3) {
            this.psswd = psswd;
        }
    }

    public static User createUser(String idNum, String psswd) {
        User user = new User(idNum, psswd);
        userList.add(user);
        return user;
    }

    public String getIdNum() { return this.idNum; }

    public String getPsswd() { return this.psswd; }

    public ArrayList<String> getCheckedOutMedia() { return this.checkedOutMedia; }

    public static ArrayList<User> getUserList() { return userList; }

    public String toString() {
        return this.idNum + ";" + this.psswd;
    }

    public void checkedOut(Media media) {
        checkedOutMedia.add(media.toString());
    }
}
