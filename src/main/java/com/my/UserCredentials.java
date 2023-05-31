package com.my;


public class UserCredentials {
    private String password;
    private String email;

   private UserCredentials(String email, String password) {
        this.email = email;
        this.password = password;
    }
    public static UserCredentials from(User user) {
        return new UserCredentials(user.getEmail(), user.getPassword());
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
