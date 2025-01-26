package model;

public class User {
    private String userID;
    private String username;
    private String phoneNumber;
    private String email;
    public User(String userID, String username, String phoneNumber, String email) {
        this.userID = userID;
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
    public String getUserID() {
        return userID;
    }
    public void setUserID(String userID) {
        this.userID = userID;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public String toString() {
        return "User [userID=" + userID + ", username=" + username + ", phoneNumber=" + phoneNumber + ", email=" + email
                + "]";
    }
}
