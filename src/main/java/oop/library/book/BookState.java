package oop.library.book;

public enum BookState {
    ON_LEND("대출중"),
    ON_LIBRARY("대출가능");
    private final String description;

    BookState(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
