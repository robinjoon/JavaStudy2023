package oop.library.library;

import oop.library.member.Member;

import java.time.Period;

public interface BookReturnCalculator {
    Period calculate(Member member);
}