package oop.library.library;

import oop.library.book.Book;

import java.time.LocalDate;
import java.time.Period;

public class LendResult {
    private final boolean result;
    private final String resultString;
    private final Period lendPeriod;
    private final Book book;

    public LendResult(boolean result, Period lendPeriod, Book book) {
        this.result = result;
        this.lendPeriod = lendPeriod;
        this.book = book;
        resultString = null;
    }
    public LendResult(boolean result, Period lendPeriod, Book book,String resultString) {
        this.result = result;
        this.lendPeriod = lendPeriod;
        this.book = book;
        this.resultString = resultString;
    }

    public Book getBook() {
        return book;
    }

    @Override
    public String toString() {
        if(resultString!=null){
            return resultString;
        }
        if(result){
            return "대출이 성공했습니다. 반납은 "+ LocalDate.now().plus(lendPeriod)+"까지 해주시기 바랍니다.";
        }
        return "대출이 거부되었습니다." +LocalDate.now().plus(lendPeriod)+"부터 대출이 가능합니다.";
    }
}
