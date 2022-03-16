package mockitotest;

import java.util.List;

public record Library(List<Book> books) {

    public List<Book> getAllBooks() {
        return books;
    }

    public int getNumberOfBooks() {
        return books.size();
    }

    public Book findBookByTitle(String title) {
        Book foundBook = null;
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getTitle() == title) {
                foundBook = books.get(i);
            }
        }
        return foundBook;
    }

    public Book findBookWithMaxPages() {
        if (books.isEmpty()) {
            throw new RuntimeException();
        }
        Book bookWithMaxPagesCount = books.get(0);

        for (int i = 1; i < books.size(); i++) {
            Book book = books.get(i);
            if (book.getPages() > bookWithMaxPagesCount.getPages()) {
                bookWithMaxPagesCount = book;
            }
        }
        return bookWithMaxPagesCount;
    }
}

        // Sunku mokinti su streamu, todel max pages ieskojom su for ciklu (auksciau)
        //   String maxBookPages = books.stream().max(Comparator.comparingInt(Book::pages)).toString();
        //   return maxBookPages;

