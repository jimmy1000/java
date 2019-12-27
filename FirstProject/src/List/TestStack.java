package List;

import charactor.Hero;

import java.util.LinkedList;

public class TestStack implements Stack {
    static LinkedList<Hero> heros= new LinkedList<>();
    @Override
    public void push(Hero h) {
        heros.addLast(h);
    }
    @Override
    public Hero pull() {
        return heros.removeLast();
    }
    @Override
    public Hero peek() {
        return heros.getLast();
    }

    public static void main(String[] args) {
        TestStack stack = new TestStack();
        System.out.println("当前栈内元素:" +heros);
        for (int i=0;i<6;i++){
            stack.push(new Hero("hero" + i));
        }
        for (int i=0;i<6;i++){
            System.out.println("弹出"+stack.peek());
                 stack.pull();
        }
    }


}
