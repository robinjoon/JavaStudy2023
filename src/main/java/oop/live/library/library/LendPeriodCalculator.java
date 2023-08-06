package oop.live.library.library;

import oop.live.library.member.Member;

import java.time.Period;

public interface LendPeriodCalculator {
    Period calculate(Member member);
}
