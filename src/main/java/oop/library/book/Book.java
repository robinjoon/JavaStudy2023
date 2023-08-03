package oop.library.book;


import oop.library.member.Member;

public class Book {
    private final String name;
    private BookState bookState;
    private Member lender;

    public Book(String name) {
        this.name = name;
        this.bookState = BookState.ON_LIBRARY;
        lender = null;
    }
    public void lend(Member lender){
        this.lender = lender;
        this.bookState = BookState.ON_LEND;
    }
    public void returned(){
        this.lender = null;
        this.bookState = BookState.ON_LIBRARY;
    }
    public String getName() {
        return name;
    }
    public Member getLender() {
        return lender;
    }
    public boolean canLend(){
        return bookState == BookState.ON_LIBRARY;
    }
}
