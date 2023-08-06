package oop.live.library.dto;

public class SearchDTO {
    private final String bookName;
    private final int totalBookCount;
    private final int remainBookCount;

    public SearchDTO(String bookName, int totalBookCount, int remainBookCount) {
        this.bookName = bookName;
        this.totalBookCount = totalBookCount;
        this.remainBookCount = remainBookCount;
    }

    public String getBookName() {
        return bookName;
    }

    public int getTotalBookCount() {
        return totalBookCount;
    }

    public int getRemainBookCount() {
        return remainBookCount;
    }
}
