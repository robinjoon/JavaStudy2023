package oop.library.library;

import oop.library.book.Book;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleLibraryFactory implements LibraryFactory {
    @Override
    public Library getInstance(String type) {
        if(!type.contentEquals("simple")){
            throw new IllegalArgumentException("지원하지 않는 Library 입니다.");
        }
        Map<String, List<Book>> bookDB = new HashMap<>();
        bookDB.put("testBook",List.of(new Book("testBook"),new Book("testBook"),new Book("testBook"),new Book("testBook"),new Book("testBook")));
        return new SimpleLibrary(BookCalculator.getInstance(),BookCalculator.getInstance(),bookDB);
    }
}
