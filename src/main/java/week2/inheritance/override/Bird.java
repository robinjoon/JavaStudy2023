package week2.inheritance.override;

public class Bird extends Animal{
    @Override // 아래 메서드가 상위 클래스에 정의된 메서드를 오버라이딩 하고 있다는 명시적 표시.
    public void makeChild(){
        System.out.println("알을 낳는다.");
    }
}