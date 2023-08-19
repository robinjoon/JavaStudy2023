package oop.library.library;

import oop.library.book.Book;
import oop.library.member.Member;
import oop.library.search.BookSearchResult;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;

class SimpleLibrary implements Library {
    private final BookReturnCalculator returnCalculator;
    private final BookLendCountCalculator lendCountCalculator;
    private final Map<Member,List<Book>> lendDB;
    private final Map<Book, LocalDate> returnDateDB;
    private final Map<String,List<Book>> bookDB;

    SimpleLibrary(BookReturnCalculator bookReturnCalculator,BookLendCountCalculator bookLendCountCalculator, Map<String,List<Book>> bookDB) {
        this.returnCalculator = bookReturnCalculator;
        this.lendCountCalculator = bookLendCountCalculator;
        lendDB = new HashMap<>();
        this.bookDB = bookDB;
        returnDateDB = new HashMap<>();
    }

    @Override
    public LendResult lendBook(Member member, Book book) {
        List<Book> lendList = lendDB.getOrDefault(member, new ArrayList<>());
        int allowLendCount = lendCountCalculator.calculateLendCount(member);

        if(lendList.size()>=allowLendCount){
            throw new IllegalStateException("더이상 대출할 수 없습니다.");
        }

        if(!book.canLend()){
            throw new IllegalStateException("이미 대출중인 책입니다.");
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
        int totalBookCount = getTotalBookCount(bookName);
        int remainBookCount = getRemainBookCount(bookName);
        if (!isKnownBook(bookName)){
            return new BookSearchResult(bookName,0,0,null);
        }
        if(canLendNow(remainBookCount)){
            return new BookSearchResult(bookName,remainBookCount,totalBookCount,LocalDate.now());
        }
        List<LocalDate> returnDates = new ArrayList<>();
        List<Book> searchedBooks = getBooks(bookName);
        for (Book searchedBook : searchedBooks) {
            returnDates.add(returnDateDB.get(searchedBook));
        }
        returnDates.sort(Comparator.naturalOrder());
        return new BookSearchResult(bookName,remainBookCount,totalBookCount,returnDates.get(0));
    }
    private int getTotalBookCount(String bookName){
        return bookDB.getOrDefault(bookName,Collections.emptyList()).size();
    }

    private int getRemainBookCount(String bookName){
        List<Book> searchedBooks = bookDB.getOrDefault(bookName,Collections.emptyList());
        int remainCount = 0;
        for (Book searchedBook : searchedBooks) {
            if(searchedBook.canLend())remainCount++;
        }
        return remainCount;
    }

    private boolean isKnownBook(String bookName){
        return getTotalBookCount(bookName)>0;
    }

    private List<Book> getBooks(String bookName){
        return bookDB.getOrDefault(bookName,Collections.emptyList());
    }

    private boolean canLendNow(int remainCount){
        return remainCount > 0;
    }
    @Override
    public List<Book> searchLendList(Member member) {
        return lendDB.get(member);
    }

    @Override
    public Book getLendAbleBook(String bookName) {
        List<Book> books = bookDB.getOrDefault(bookName,Collections.emptyList());
        if(books.isEmpty()){
            throw new IllegalArgumentException("구비중인 책이 아닙니다.");
        }
        for (Book book : books) {
            if (book.canLend())return book;
        }
        throw new IllegalStateException("대출 가능한 책이 없습니다.");
    }
}
