package oop.library.library;

import oop.library.member.BasicMember;
import oop.library.member.Member;

import java.time.Period;

public class BookCalculator implements BookReturnCalculator, BookLendCountCalculator{
    private static final BookCalculator b = new BookCalculator();
    public static BookCalculator getInstance(){
        return b;
    }
    private BookCalculator(){}
    @Override
    public Period calculate(Member member) {
        if(member instanceof BasicMember){
            return Period.of(0,0,7);
        }
        throw new IllegalArgumentException("없는 회원등급입니다.");
    }

    @Override
    public int calculateLendCount(Member member) {
        if (member instanceof BasicMember){
            return 3;
        }
        throw new IllegalArgumentException("없는 회원등급입니다.");
    }
}
