package oop.live.library.member;

import oop.live.library.book.Book;
import oop.live.library.dto.LendDTO;
import oop.live.library.dto.ReturnDTO;
import oop.live.library.dto.SearchDTO;

public interface Member {
    LendDTO lend(Book book);
    ReturnDTO returnBook(Book book);
    SearchDTO search(Book book);
}
