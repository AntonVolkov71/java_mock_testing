package org.example.service_2;

import java.util.Collections;
import java.util.List;

public class AuthService2 {
    public List<String> getAuthorsList(List<Integer> bookIdList) {
        //найти в базе данных список уникальных авторов для заданных книг
        return Collections.emptyList();
    }

    public String getAuthorDescription(int authorId) {
        //сложная логика по формированию описания автора из базы данных
        return "описание";
    }
}
