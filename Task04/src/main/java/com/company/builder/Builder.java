package com.company.builder;

import com.company.exception.RepositoryException;

import java.sql.ResultSet;

public interface Builder<T> {
    T build(ResultSet resultSet) throws RepositoryException;
}
