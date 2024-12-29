import org.example.service_2.AuthService2;
import org.example.service_2.BookService2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BookServiceTest {
    @Test
    void testCreateAuthorListDescription() {
        BookService2 bookService = new BookService2();
        AuthService2 mockAuthorService = Mockito.mock(AuthService2.class);
        bookService.setAuthorService(mockAuthorService);

        List<String> authors =new ArrayList<>();
        authors.add("Шекспир");
        authors.add("Байрон");

        Mockito
                .when(mockAuthorService.getAuthorsList(Mockito.anyList()))
                .thenReturn(List.of("Шекспир", "Байрон"));
        String description = bookService.createAuthorListDescription(Arrays.asList(3, 12, 7, 4));

        Assertions.assertEquals("Эти 4 книги были написаны 2 авторами: Шекспир Байрон ", description);
    }
}
