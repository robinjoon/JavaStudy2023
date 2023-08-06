package oop.live.library.library;

import oop.live.library.member.BasicMember;
import oop.live.library.member.Member;

public class SimpleMaxLendCountCalculator implements MaxLendCountCalculator {
    @Override
    public int calculate(Member member) {
        if (member instanceof BasicMember){
            return 3;
        }
        throw new IllegalArgumentException("없는 회원입니다.");
    }
}
