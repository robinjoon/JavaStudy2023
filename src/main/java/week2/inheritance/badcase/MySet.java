package week2.inheritance.badcase;

import java.util.Collection;
import java.util.HashSet;

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
}
