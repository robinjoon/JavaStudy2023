package oop.library.library;

import java.time.LocalDate;
import java.time.Period;

public class ReturnResult {
    private final Period lendBanPeriod;

    public ReturnResult(Period lendBanPeriod) {
        this.lendBanPeriod = lendBanPeriod;
    }

    @Override
    public String toString() {
        return "반납이 완료되었습니다. 다음 대출은 "+ LocalDate.now().plus(lendBanPeriod)+"부터 가능합니다.";
    }
}
