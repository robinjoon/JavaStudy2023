package nested;


public class OutClass {
    private int outPrivate;
    private static int outStaticPrivate = 1;
    public void method1(){
        class InnerClass1{ // 메서드 내부에서만 쓸 수 있다.
            void innerMethod(){
                outStaticPrivate = 2;
                outPrivate = 1;
            }
        }

        InnerClass1 innerClass1 = new InnerClass1();
        innerClass1.innerMethod();
        System.out.println(outPrivate);
    }

    public class InnerClass2{ // public 접근제어자를 가지기 때문에 외부에서 사용할 수 있다.
        public void printOutPrivate(){
            OutClass.this.outPrivate = 2;
            System.out.println(outPrivate);
        }
    }
    private static void outStaticMethod(){
        System.out.println("외부 클래스 스테틱 메서드");
    }

    public static class StaticInnerClass{
        public void printOut(){
            outStaticPrivate = 2;
            outStaticMethod();
            System.out.println(outStaticPrivate);
            System.out.println("출력 불가");
        }
    }
}
