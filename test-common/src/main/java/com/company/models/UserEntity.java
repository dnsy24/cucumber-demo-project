package com.company.models;

import io.cucumber.java.DataTableType;

import java.util.Map;

public class UserEntity {
    @DataTableType
    public User userEntry(Map<String, String> entry) {
        return new User(
                entry.get("email"),
                entry.get("password"));
    }
}
