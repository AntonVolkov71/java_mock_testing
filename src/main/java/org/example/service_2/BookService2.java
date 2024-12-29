package org.example.service_2;

import java.util.List;

public class BookService2 {
    private AuthService2 authorService;

    public void setAuthorService(AuthService2 authorService) {
        this.authorService = authorService;
    }

    public String createAuthorListDescription(List<Integer> bookIdList) {
        List<String> authorList = authorService.getAuthorsList(bookIdList);

        StringBuilder result = new StringBuilder("Эти ")
                .append(bookIdList.size())
                .append(" книги были написаны ")
                .append(authorList.size())
                .append(" авторами: ");

        for (String author: authorList) {
            result.append(author).append(" ");
        }

        return result.toString();
    }
}
