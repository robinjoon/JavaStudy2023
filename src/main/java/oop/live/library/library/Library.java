package oop.live.library.library;

import oop.live.library.book.Book;
import oop.live.library.dto.LendDTO;
import oop.live.library.dto.LendInfo;
import oop.live.library.dto.ReturnDTO;
import oop.live.library.dto.SearchDTO;
import oop.live.library.member.Member;

import java.util.List;

public interface Library {
    LendDTO lend(Member member, Book book);
    ReturnDTO returnBook(Member member, Book book);
    SearchDTO search(String bookName);
    List<LendInfo> searchLendList(Member member);
}
