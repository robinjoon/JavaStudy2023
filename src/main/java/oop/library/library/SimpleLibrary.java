package oop.library.library;

import oop.library.book.Book;
import oop.library.member.Member;
import oop.library.search.BookSearchResult;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class SimpleLibrary implements Library {
    private final BookReturnCalculator returnCalculator;
    private final BookLendCountCalculator lendCountCalculator;
    private final Map<Member,List<Book>> lendDB;
    private final Map<Book, LocalDate> returnDateDB;
    private final Map<String,List<Book>> bookDB;

    public SimpleLibrary(BookReturnCalculator bookReturnCalculator,BookLendCountCalculator bookLendCountCalculator) {
        this.returnCalculator = bookReturnCalculator;
        this.lendCountCalculator = bookLendCountCalculator;
        lendDB = new HashMap<>();
        bookDB = new HashMap<>();
        bookDB.put("testBook",List.of(new Book("testBook"),new Book("testBook"),new Book("testBook"),new Book("testBook"),new Book("testBook")));
        returnDateDB = new HashMap<>();
    }

    @Override
    public LendResult lendBook(Member member, Book book) {
        List<Book> lendList = lendDB.getOrDefault(member, new ArrayList<>());
        int allowLendCount = lendCountCalculator.calculateLendCount(member);

        if(lendList.size()>=allowLendCount){
            return new LendResult(false, Period.ZERO,book);
        }

        if(!book.canLend()){
            return new LendResult(false, Period.ZERO,book,"이미 대출중인 책입니다.");
        }

        book.lend(member);
        insertLend(member, book);
        return new LendResult(true,returnCalculator.calculate(member),book);
    }
    private void insertLend(Member member, Book book) {
        List<Book> lendList = lendDB.getOrDefault(member,new ArrayList<>());
        lendList.add(book);
        lendDB.put(member,lendList);
        returnDateDB.put(book,LocalDate.now().plus(returnCalculator.calculate(member)));
    }

    @Override
    public ReturnResult returnBook(Member member, Book book) {
        if(member != book.getLender()){
            throw new IllegalArgumentException("회원이 대출한 책이 아닙니다.");
        }
        book.returned();
        List<Book> lendList = lendDB.get(member);
        lendList.remove(book);
        LocalDate returnLimitDate = returnDateDB.remove(book);
        Period period = Period.between(returnLimitDate,LocalDate.now());
        if (period.isNegative()){
            period = Period.ZERO;
        }
        return new ReturnResult(period);
    }

    @Override
    public boolean canLend(Member member) {
        int nowLendCount = lendDB.getOrDefault(member,Collections.emptyList()).size();
        return lendCountCalculator.calculateLendCount(member)>nowLendCount;
    }

    @Override
    public BookSearchResult search(String bookName) {
        List<Book> searchedBooks = bookDB.getOrDefault(bookName,Collections.emptyList());
        if (searchedBooks.isEmpty()){
            return null;
        }
        int remainCount = 0;
        for (Book searchedBook : searchedBooks) {
            if(searchedBook.canLend())remainCount++;
        }
        if(remainCount == 0){
            List<LocalDate> returnDates = new ArrayList<>();
            for (Book searchedBook : searchedBooks) {
                returnDates.add(returnDateDB.get(searchedBook));
            }
            returnDates.sort(Comparator.naturalOrder());
            return new BookSearchResult(bookName,remainCount,searchedBooks.size(),returnDates.get(0));
        }
        return new BookSearchResult(bookName,remainCount,searchedBooks.size(),LocalDate.now());
    }

    @Override
    public List<Book> searchLendList(Member member) {
        return lendDB.get(member);
    }

    @Override
    public Book getLendAbleBook(String bookName) {
        List<Book> books = bookDB.getOrDefault(bookName,Collections.emptyList());
        if(books.isEmpty()){
            return null;
        }
        for (Book book : books) {
            if (book.canLend())return book;
        }
        return null;
    }
}
