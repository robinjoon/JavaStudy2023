package oop.live.library.member;

import oop.live.library.book.Book;
import oop.live.library.dto.LendDTO;
import oop.live.library.dto.ReturnDTO;
import oop.live.library.dto.SearchDTO;

public class BasicMember implements Member {
    @Override
    public LendDTO lend(Book book) {
        return null;
    }

    @Override
    public ReturnDTO returnBook(Book book) {
        return null;
    }

    @Override
    public SearchDTO search(Book book) {
        return null;
    }
}
