package oop.library.member;

import oop.library.book.Book;

public interface Member {
    void lendBook(Book book);
    void returnBook(Book book);
    void searchBook(String bookName);
}
