package mockitotest;

public class Book {
    private int pages;
    private String title;

    public Book(int pages, String title) {
        this.pages = pages;
        this.title = title;
    }

    public int getPages() {
        return pages;
    }

    public String getTitle() {
        return title;
    }
}