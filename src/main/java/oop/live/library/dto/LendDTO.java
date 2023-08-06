package oop.live.library.dto;

import java.time.LocalDate;
import java.time.Period;

public class LendDTO {
    private final String result;
    private final String bookName;
    private final LocalDate lendDate;
    private final Period lendPeriod;

    public LendDTO(String result, String bookName, LocalDate lendDate, Period lendPeriod) {
        this.result = result;
        this.bookName = bookName;
        this.lendDate = lendDate;
        this.lendPeriod = lendPeriod;
    }

    public String getResult() {
        return result;
    }

    public String getBookName() {
        return bookName;
    }

    public LocalDate getLendDate() {
        return lendDate;
    }

    public Period getLendPeriod() {
        return lendPeriod;
    }
}
