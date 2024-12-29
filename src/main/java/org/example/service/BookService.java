package org.example.service;

import java.sql.SQLException;

public class BookService {
    private AuthorService authorService;

    public void setAuthorService(AuthorService authorService) {
        this.authorService = authorService;
    }

    public String createBookDescription(String bookName, int creationYear, int authorId, String authorName) {
        StringBuffer description = new StringBuffer();
        description.append(bookName).append(", ");
        description.append(creationYear);

        try {
            String authorDescription = authorService.getAuthorDescription(authorId);
            if (authorDescription != null) {
                description.append(" автор ");
                description.append(authorName).append(", ");
                description.append(authorDescription);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return description.toString();
    }
}
