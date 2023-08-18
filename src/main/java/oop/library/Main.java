package oop.library;

import oop.library.book.Book;
import oop.library.library.BookCalculator;
import oop.library.library.Library;
import oop.library.library.SimpleLibrary;
import oop.library.member.BasicMember;
import oop.library.member.Member;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Library library = new SimpleLibrary(BookCalculator.getInstance(),BookCalculator.getInstance());
        Member member = new BasicMember(library);

        System.out.println(library.search("testBook"));

        Book testBook = library.getLendAbleBook("testBook");
        member.lendBook(testBook);

        System.out.println(library.search("testBook"));

        member.returnBook(testBook);

        System.out.println(library.search("testBook"));

        Member member2 = new BasicMember(library);
        member2.lendBook(testBook);

        System.out.println(library.search("testBook"));
    }
}
