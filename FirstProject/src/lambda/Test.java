package lambda;

import charactor.Hero;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        List<Hero>  heros = new ArrayList<>();
        Random r = new Random();
        for (int i=0 ; i < 10 ; i++){
            heros.add(new Hero("Hero0"+i,r.nextInt(1000),r.nextInt(1000)));
        }
        //传统方式
        System.out.println("初始化后的集合");
        System.out.println(heros);
        Collections.sort(heros, new Comparator<Hero>() {
            @Override
            public int compare(Hero o1, Hero o2) {
                return (int)(o2.hp-o1.hp);
            }
        });
        System.out.println("匿名类方式取得hp第三高的是：\n"+heros.get(2).name);

        //聚合方式
        System.out.println("聚合方法");
        Hero hero=
                heros
                .stream()
                .sorted((h1,h2)-> (int) (h2.hp-h1.hp))
                .skip(2)
                .findFirst()
                .get();
        System.out.println(hero);
    }
}
