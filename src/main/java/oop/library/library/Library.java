package oop.library.library;

import oop.library.book.Book;
import oop.library.member.Member;
import oop.library.search.BookSearchResult;

import java.util.List;

public interface Library {
    LendResult lendBook(Member member, Book book);

    ReturnResult returnBook(Member member, Book book);

    boolean canLend(Member member);

    BookSearchResult search(String bookName);
    List<Book> searchLendList(Member member);
    Book getLendAbleBook(String bookName);
}
