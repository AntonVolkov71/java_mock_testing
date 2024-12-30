import org.example.service.AuthorService;
import org.example.service.BookService;
import org.example.service.MockAuthorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.SQLException;

public class TestService {
    @Test
    public void testCreateBookDescription() {
        BookService bookService = new BookService();
        AuthorService mockAuthorService = new MockAuthorService();
        bookService.setAuthorService(mockAuthorService);

        String bookDescription = bookService.createBookDescription("Война и мир", 1898, 5, "Л.Н.Толстой");

        // Ожидаемое значение
        String expected = "Война и мир, 1898 автор Л.Н.Толстой, знаменитый русский писатель";
        Assertions.assertEquals(expected, bookDescription, "Тест должен был провалиться!");
    }

    @Test
    public void testCreateBookDescriptionMockito() throws SQLException {

        BookService bookService = new BookService();
        AuthorService mockAuthorService = Mockito.mock(AuthorService.class);
        bookService.setAuthorService(mockAuthorService);

        Mockito
                .when(mockAuthorService.getAuthorDescription(Mockito.anyInt()))
                .thenReturn("знаменитый русский писатель");

        String bookDescription = bookService.createBookDescription("Война и мир", 1898, 5, "Л.Н.Толстой");

        Assertions.assertEquals("Война и мир, 1898 автор Л.Н.Толстой, знаменитый русский писатель", bookDescription);

    }

    @Test
    void testCreateBookDescriptionComplexLogic() throws SQLException {
        BookService bookService = new BookService();
        AuthorService mockAuthorService = Mockito.mock(AuthorService.class);
        bookService.setAuthorService(mockAuthorService);

        Mockito
                .when(mockAuthorService.getAuthorDescription(Mockito.anyInt()))
                .thenAnswer(invocationOnMock  -> {
                    int authorId = invocationOnMock.getArgument(0, Integer.class);

                    if(authorId % 2 == 0){
                        return "великий русский писатель";
                    } else {
                        //нечётные id у английских авторов
                        return "великий английский писатель";
                    }
                });

        String bookDescriptionEnglish = bookService.createBookDescription("Гамлет", 1599, 11, "Уильям Шекспир");
        Assertions.assertEquals("Гамлет, 1599 автор Уильям Шекспир, великий английский писатель", bookDescriptionEnglish);

        String bookDescriptionRussian = bookService.createBookDescription("Война и мир", 1898, 6, "Л.Н.Толстой");
        Assertions.assertEquals("Война и мир, 1898 автор Л.Н.Толстой, великий русский писатель", bookDescriptionRussian);
    }
}
