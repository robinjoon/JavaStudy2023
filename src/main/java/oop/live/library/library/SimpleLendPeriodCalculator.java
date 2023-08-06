package oop.live.library.library;

import oop.live.library.member.BasicMember;
import oop.live.library.member.Member;

import java.time.Period;

public class SimpleLendPeriodCalculator implements LendPeriodCalculator {
    @Override
    public Period calculate(Member member) {
        if (member instanceof BasicMember){
            return Period.ofDays(7);
        }
        throw new IllegalArgumentException("없는 회원입니다.");
    }
}
