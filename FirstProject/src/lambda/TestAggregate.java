package lambda;

import charactor.Hero;

import javax.swing.*;
import java.util.*;

public class TestAggregate {
    public static void main(String[] args) {
        Random r = new Random();
        List<Hero> heros = new ArrayList<>();
        for (int i=1;i<10;i++){
            heros.add(new Hero("hero " + i, r.nextInt(1000), r.nextInt(100)));
        }
        System.out.println("初始化集合后的数据 (最后一个数据重复)：");
        System.out.println(heros);
        //传统方式
        Collections.sort(heros, new Comparator<Hero>() {
            @Override
            public int compare(Hero o1, Hero o2) {
                return (int)(o2.hp-o1.hp);
            }
        });
        Hero  hero = heros.get(2);
        System.out.println("通过传统方式找出来的hp第三高的英雄为"+hero);
        //聚合方式
        //制造一个重复数据
        heros.add(heros.get(0));
        System.out.println("初始化集合后的数据 (最后一个数据重复)：");
        System.out.println(heros);
        System.out.println("满足条件hp>100&&damage<50的数据");
        heros
                .stream()
                .filter(h->h.hp>100&&h.damage<50)
                .forEach(h->System.out.print(h));
        System.out.println("去除重复的数据，去除标准是看equals");
        heros
                .stream()
                .distinct()
                .forEach(h->System.out.print(h));
        System.out.println("按照血量排序");
        heros
                .stream()
                .sorted((h1,h2)->h1.hp>=h2.hp?1:-1)
                .forEach(h->System.out.print(h));
        System.out.println("保留3个");
        heros
                .stream()
                .limit(3)
                .forEach(h-> System.out.println(h));
        System.out.println("忽略前3个");
        heros
                .stream()
                .skip(3)
                .forEach(h->System.out.print(h));
        System.out.println("转换为double的Stream");
        heros
                .stream()
                .mapToDouble(Hero::getHp)
                .forEach(h->System.out.println(h));


    }
}
