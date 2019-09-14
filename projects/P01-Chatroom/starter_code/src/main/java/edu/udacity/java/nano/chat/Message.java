package edu.udacity.java.nano.chat;

/**
 * WebSocket message model
 */
public class Message {
    public static String ENTER = "ENTER";
    public static String SPEAK = "SPEAK";
    public static String QUIT = "QUIT";
    String msg;
    String username;
    String type;
    int onlineCount;

    public String getType() {
        return type;
    }

    public Message(String msg, String username, String type, int onlineCount) {
        this.msg = msg;
        this.username = username;
        this.type = type;
        this.onlineCount = onlineCount;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getOnlineCount() {
        return onlineCount;
    }

    public void setOnlineCount(int onlineCount) {
        this.onlineCount = onlineCount;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
