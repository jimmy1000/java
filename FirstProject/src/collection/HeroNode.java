package collection;

import charactor.Hero;

import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HeroNode {
    //左节点
    public HeroNode leftNode;
    //右节点
    public HeroNode rightNode;
    public Hero value;

    public void add(Hero h) {
        if (null == value) {
            value = h;
        }else
        if (h.hp - value.hp <= 0) {
            if (null == leftNode)
                leftNode = new HeroNode();
            leftNode.add(h);
        } else {
            if (null == rightNode)
                rightNode=new HeroNode();
            rightNode.add(h);
        }
    }
    public List<Object> values() {
        List<Object> values = new ArrayList<>();
        //左边的遍历节点
        if (leftNode != null)
            values.addAll(leftNode.values());
        //当前节点
        values.add(value);
        //右边的遍历节点
        if (rightNode != null)
            values.addAll(rightNode.values());
        return values;
    }

    public static void main(String[] args) {
        List<Hero> heros = new ArrayList<>();
        for (int i=0;i<10;i++){
            heros.add(new Hero("Hero0"+i,(int) Math.random()*1000));
        }
        HeroNode   roots = new HeroNode();
        for (Hero h : heros){
            roots.add(h);
        }
        System.out.println("为排序前:"+"\n"+roots);
        System.out.println("排序后:"+roots.values());
    }
}