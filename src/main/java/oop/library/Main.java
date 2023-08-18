package oop.library;

import oop.library.book.Book;
import oop.library.library.BookCalculator;
import oop.library.library.Library;
import oop.library.library.SimpleLibrary;
import oop.library.member.BasicMember;
import oop.library.member.Member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String,List<Book>> bookDB = new HashMap<>();
        bookDB.put("testBook",List.of(new Book("testBook"),new Book("testBook"),new Book("testBook"),new Book("testBook"),new Book("testBook")));

        Library library = new SimpleLibrary(BookCalculator.getInstance(),BookCalculator.getInstance(),bookDB);
        Member member = new BasicMember(library);

        member.searchBook("testBook");

        Book testBook = library.getLendAbleBook("testBook");
        member.lendBook(testBook);

        member.searchBook("testBook");

        member.returnBook(testBook);

        member.searchBook("testBook");

        Member member2 = new BasicMember(library);
        member2.lendBook(testBook);

        member.searchBook("testBook");
    }
}
