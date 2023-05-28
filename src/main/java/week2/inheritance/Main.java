package week2.inheritance;

public class Main
{
    public static void main(String[] args) {
        B b = new B();
        b.publicMethod(); // A의 프라이빗 메서드 출력. 즉, A 의 private, final 인 것들도 그대로 상속 받는다.
    }
}
class A{
    public void publicMethod(){
        privateMethod();
    }
    private final void privateMethod(){
        System.out.println("A의 프라이빗 메서드");
    }
}
class B extends A{

}