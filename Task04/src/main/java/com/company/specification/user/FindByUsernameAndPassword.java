package com.company.specification.user;

import com.company.specification.Specification;

import java.util.Arrays;
import java.util.List;

public class FindByUsernameAndPassword implements Specification {

    private final String username;
    private final String password;

    public FindByUsernameAndPassword(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toSql() {
        return "where username = ? AND password = ?";
    }

    @Override
    public List<Object> getParameters() {
        return Arrays.asList(username, password);
    }

}
