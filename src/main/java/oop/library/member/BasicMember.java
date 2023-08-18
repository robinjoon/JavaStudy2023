package oop.library.member;

import oop.library.book.Book;
import oop.library.library.LendResult;
import oop.library.library.Library;
import oop.library.library.ReturnResult;
import oop.library.search.BookSearchResult;

public class BasicMember implements Member {
    private final Library library;

    public BasicMember(Library library) {
        this.library = library;
    }

    @Override
    public void lendBook(Book book) {
        LendResult lendResult = library.lendBook(this, book);
        System.out.println(lendResult);
    }

    @Override
    public void returnBook(Book book) {
        ReturnResult returnResult = library.returnBook(this, book);
        System.out.println(returnResult);
    }

    @Override
    public void searchBook(String bookName) {
        BookSearchResult searchResult = library.search(bookName);
        System.out.println(searchResult);
    }
}
