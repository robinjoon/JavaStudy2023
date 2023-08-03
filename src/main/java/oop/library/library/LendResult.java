package oop.library.library;

import java.time.LocalDate;
import java.time.Period;

public class LendResult {
    private final boolean result;
    private final Period lendPeriod;

    public LendResult(boolean result, Period lendPeriod) {
        this.result = result;
        this.lendPeriod = lendPeriod;
    }

    @Override
    public String toString() {
        if(result){
            return "대출이 성공했습니다. 반납은 "+ LocalDate.now().plus(lendPeriod)+"까지 해주시기 바랍니다.";
        }
        return "대출이 거부되었습니다." +LocalDate.now().plus(lendPeriod)+"부터 대출이 가능합니다.";
    }
}
