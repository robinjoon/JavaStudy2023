package week2.inheritance.badcase;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class MySet extends HashSet<String> {
    private int addTryCount = 0;

    @Override
    public boolean add(String s) {
        addTryCount++;
        return super.add(s);
    }

    @Override
    public boolean addAll(Collection<? extends String> c) {
        addTryCount += c.size(); // 원소 수만큼 증가
        return super.addAll(c);
    }

    public int getAddTryCount() {
        return addTryCount;
    }

    public static void main(String[] args) {
        MySet mySet = new MySet();
        mySet.add("aa");
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        mySet.addAll(list);
        System.out.println(mySet.getAddTryCount());
    }
}
