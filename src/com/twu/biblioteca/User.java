package com.twu.biblioteca;

import java.util.ArrayList;

public class User {
    private String idNum;
    private String psswd;
    private ArrayList<String> checkedOutMedia = new ArrayList<String>();

    public User(String idNum, String psswd) {
        if (idNum.length() == 8) {
            this.idNum = idNum;
        }
        if (psswd.length() > 3) {
            this.psswd = psswd;
        }
    }

    public void checkedOut(Media media) {
        checkedOutMedia.add(media.toString());
    }

    public ArrayList<String> getCheckedOutMedia() {
        return this.checkedOutMedia;
    }
}
