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
    private static ArrayList<User> userList = new ArrayList<User>();

    private User(String idNum, String psswd, String name, String tel, String email) {
        if (idNum.length() == 8 && idNum.contains("-")) {
            this.idNum = idNum;
        }
        if (psswd.length() > 3) {
            this.psswd = psswd;
        }
        if (tel.length() > 8) {
            this.tel = tel;
        }
        if (email.contains("@") && email.contains(".")) {
            this.email = email;
        }
        this.name = name;
    }

    static User createUser(String idNum, String psswd, String name, String tel, String email) {
        User user = new User(idNum, psswd, name, tel, email);
        userList.add(user);
        return user;
    }

    String getIdNum() { return this.idNum; }

    String getPsswd() { return this.psswd; }

    String getName() { return this.name; }

    String getNumber() { return this.tel; }

    String getEmail() { return this.email; }

    ArrayList<String> getCheckedOutMedia() { return this.checkedOutMedia; }

    static ArrayList<User> getUserList() { return userList; }

    public String toString() { return this.idNum + ";" + this.psswd; }

    void checkedOut(Media media) { checkedOutMedia.add(media.toString()); }

    void returned(Media media) { checkedOutMedia.remove(media.toString()); }

    String getUserContacts() {
        return "ID: " + this.getIdNum() + ", Name: " + this.getName() + ", Tel: " + this.getNumber() + ", Email: " + this.getEmail();
    }


    static User authenticate(String userID, String password) {
        User userFound = null;

        for (User user : User.getUserList()) {
            String dbuser = user.toString();
            String dbId = dbuser.split(";")[0];
            String dbpsswd = dbuser.split(";")[1];

            if (dbId.equals(userID) && dbpsswd.equals(password)) {

                userFound = user;

            }
        }
        return userFound;
    }
}
