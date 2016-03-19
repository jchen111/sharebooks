package com.sharebooks.domain

/**
 * Created by z001ktb on 3/18/16.
 */
class User {
    private String firstName
    private String lastName
    private String nickName
    private String email
    private String password

    User(String firstName, String lastName, String nickName, String email, String password) {
        this.firstName = firstName
        this.lastName = lastName
        this.nickName = nickName
        this.email = email
        this.password = password
    }

    String getFirstName() {
        this.firstName
    }

    String getLastName() {
        this.lastName
    }

    String getNickName() {
        this.nickName
    }

    String getEmail() {
        this.email
    }

    String getPassword() {
        this.password
    }
}
