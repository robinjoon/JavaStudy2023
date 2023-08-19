package nested;

public class Main {
    public static void main(String[] args) {
        OutClass outClass = new OutClass();

        OutClass.InnerClass2 innerClass2 = outClass.new InnerClass2();
        innerClass2.printOutPrivate();
        outClass.method1();
        innerClass2.printOutPrivate();

        OutClass.StaticInnerClass staticInnerClass = new OutClass.StaticInnerClass();
        staticInnerClass.printOut();
    }
}
