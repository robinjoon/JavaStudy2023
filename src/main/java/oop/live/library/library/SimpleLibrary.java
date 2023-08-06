package oop.live.library.library;

import oop.live.library.book.Book;
import oop.live.library.dto.LendDTO;
import oop.live.library.dto.LendInfo;
import oop.live.library.dto.ReturnDTO;
import oop.live.library.dto.SearchDTO;
import oop.live.library.member.Member;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public class SimpleLibrary implements Library {
    private final LendPeriodCalculator lendPeriodCalculator;
    private final MaxLendCountCalculator maxLendCountCalculator;

    public SimpleLibrary(LendPeriodCalculator lendPeriodCalculator, MaxLendCountCalculator maxLendCountCalculator) {
        this.lendPeriodCalculator = lendPeriodCalculator;
        this.maxLendCountCalculator = maxLendCountCalculator;
    }

    @Override
    public LendDTO lend(Member member, Book book) {
        int maxLendCount = maxLendCountCalculator.calculate(member);
        int remainLendCount = 1;
        if(maxLendCount > remainLendCount){
            // 빌릴 수 있음
            Period lendPeriod = lendPeriodCalculator.calculate(member);
            // 빌리는 처리 => 빌린 내용을 기록
            return new LendDTO("대출이 성공", book.getBookName(), LocalDate.now(),lendPeriod);
        }
        return null; // 빌릴 수 없다는 응답
    }

    @Override
    public ReturnDTO returnBook(Member member, Book book) {
        return null;
    }

    @Override
    public SearchDTO search(String bookName) {
        return null;
    }

    @Override
    public List<LendInfo> searchLendList(Member member) {
        return null;
    }
}
