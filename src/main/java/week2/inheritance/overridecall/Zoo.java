package week2.inheritance.overridecall;

import week2.inheritance.type.*;

public class Zoo{
    public static void main(String[] args){
        Animal pingu = new Bird(); // 상위 클래스인 Animal로 선언된 변수 pingu 에 하위 클래스인 Bird 의 인스턴스를 대입.
        pingu.makeChild(); // 변수 pingu는 Animal 타입임에도 알을 낳는다. 출력
    }
}