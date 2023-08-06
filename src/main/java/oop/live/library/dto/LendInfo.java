package oop.live.library.dto;

import java.time.LocalDate;
import java.time.Period;

public class LendInfo {
    private final String bookName;
    private final LocalDate lendDate;
    private final Period lendPeriod;

    public LendInfo(String bookName, LocalDate lendDate, Period lendPeriod) {
        this.bookName = bookName;
        this.lendDate = lendDate;
        this.lendPeriod = lendPeriod;
    }

    public String getBookName() {
        return bookName;
    }

    public LocalDate getLendDate() {
        return lendDate;
    }

    public LocalDate getReturnDate(){
        return lendDate.plus(lendPeriod);
    }
}
