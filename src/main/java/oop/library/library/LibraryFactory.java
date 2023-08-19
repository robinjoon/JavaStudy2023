package oop.library.library;

import oop.library.book.Book;
import oop.library.member.BasicMember;
import oop.library.member.Member;

import java.time.Period;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LibraryFactory {
    public Library getInstance(String type) {
        if(!type.contentEquals("simple")){
            throw new IllegalArgumentException("지원하지 않는 Library 입니다.");
        }
        Map<String, List<Book>> bookDB = new HashMap<>();
        bookDB.put("testBook",List.of(new Book("testBook"),new Book("testBook"),new Book("testBook"),new Book("testBook"),new Book("testBook")));
        BookLendCountCalculator lendCountCalculator = new BookLendCountCalculator() {
            @Override
            public int calculate(Member member) {
                if (member instanceof BasicMember){
                    return 3;
                }
                throw new IllegalArgumentException("없는 회원등급입니다.");
            }
        };

        BookReturnCalculator returnCalculator = new BookReturnCalculator() {
            @Override
            public Period calculate(Member member) {
                if(member instanceof BasicMember){
                    return Period.of(0,0,7);
                }
                throw new IllegalArgumentException("없는 회원등급입니다.");
            }
        };
        return new SimpleLibrary(returnCalculator,lendCountCalculator,bookDB);
    }
}
