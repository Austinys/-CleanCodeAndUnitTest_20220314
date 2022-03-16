package com.swedbank.itacademy.unittests;

import mockitotest.Book;
import mockitotest.Library;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class LibraryTest {

    @Mock
    private List<Book> mockedBooks;

    @InjectMocks
    private Library library;

    @Test
    public void Should_GetAllBooks() {
        when(mockedBooks.get(0)).thenReturn(new Book(10, "title"));

        assertEquals(10, library.getAllBooks().get(0).getPages());
        assertEquals("title", library.getAllBooks().get(0).getTitle());
    }

    @Test
    public void Should_GetNumberOfBooks() {
        when(mockedBooks.size()).thenReturn(3);
        assertEquals(3, library.getNumberOfBooks());
    }

    @Test
    public void Should_FindBookByTitle() {
        when(mockedBooks.size()).thenReturn(3);
        when(mockedBooks.get(0)).thenReturn(new Book(525, "title1"));
        when(mockedBooks.get(1)).thenReturn(new Book(413, "title2"));
        when(mockedBooks.get(2)).thenReturn(new Book(112, "title3"));

        Book actual = library.findBookByTitle("title1");

        assertEquals("title1", actual.getTitle());
    }

    @Test
    public void Should_ThrowRuntimeException_WhenLibraryIsEmpty() {
        when(mockedBooks.isEmpty()).thenReturn(true);
        assertThrows(RuntimeException.class, () -> library.findBookWithMaxPages());
    }

    @Test
    public void Should_FindBookWithMaxPages_WhenLibraryHasBooks() {
        when(mockedBooks.size()).thenReturn(2);
        when(mockedBooks.get(0)).thenReturn(new Book(55, "title1"));
        when(mockedBooks.get(1)).thenReturn(new Book(43, "title2"));

        Book actual = library.findBookWithMaxPages();

        assertEquals(55, actual.getPages());
    }
}
