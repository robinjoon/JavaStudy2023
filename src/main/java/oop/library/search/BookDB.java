package oop.library.search;

import java.util.List;

public interface BookDB {
    List<BookSearchResult> searchAll(String bookName);
    BookSearchResult search(String bookName);
}
