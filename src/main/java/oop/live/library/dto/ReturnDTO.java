package oop.live.library.dto;

import java.time.LocalDate;

public class ReturnDTO {
    private final String result;
    private final String bookName;
    private final LocalDate lendAbleDate;

    public ReturnDTO(String result, String bookName, LocalDate lendAbleDate) {
        this.result = result;
        this.bookName = bookName;
        this.lendAbleDate = lendAbleDate;
    }

    public String getResult() {
        return result;
    }

    public String getBookName() {
        return bookName;
    }

    public LocalDate getLendAbleDate() {
        return lendAbleDate;
    }
}
