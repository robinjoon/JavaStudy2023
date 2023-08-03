package oop.library.search;

import java.time.LocalDate;

public class BookSearchResult {
    private final String name;
    private final int remainCount;
    private final int totalCount;
    private final LocalDate returnDate;

    public BookSearchResult(String name, int remainCount, int totalCount, LocalDate returnDate) {
        this.name = name;
        this.remainCount = remainCount;
        this.totalCount = totalCount;
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "BookSearchDTO{" +
                "name='" + name + '\'' +
                ", remainCount=" + remainCount +
                ", totalCount=" + totalCount +
                ", returnDate=" + returnDate +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getRemainCount() {
        return remainCount;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }
}
