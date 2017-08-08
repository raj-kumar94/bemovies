package com.example.raj.bemovies;

/**
 * Created by raj on 08-Aug-17.
 */
public class Chat {
    int userID;
    String messsage;
    String timestamp;

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getMesssage() {
        return messsage;
    }

    public void setMesssage(String messsage) {
        this.messsage = messsage;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Chat(int userID, String messsage, String timestamp) {

        this.userID = userID;
        this.messsage = messsage;
        this.timestamp = timestamp;
    }
}
