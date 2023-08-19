package oop.library;

import oop.library.book.Book;
import oop.library.library.Library;
import oop.library.library.LibraryFactory;
import oop.library.member.BasicMember;
import oop.library.member.Member;

public class Main {
    public static void main(String[] args) {
        Library library = new LibraryFactory().getInstance("simple");
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
