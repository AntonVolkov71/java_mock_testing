package org.example.service;

import java.sql.SQLException;

public class MockAuthorService extends AuthorService{
    @Override
    public String getAuthorDescription(int authorId) throws SQLException {
        return "знаменитый русский писатель";
    }
}
