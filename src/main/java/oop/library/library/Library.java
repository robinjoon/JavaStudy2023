package oop.library.library;

import oop.library.book.Book;
import oop.library.member.Member;

public interface Library {
    LendResult lendBook(Member member, Book book);

    ReturnResult returnBook(Member member, Book book);

    boolean canLend(Member member);
}
