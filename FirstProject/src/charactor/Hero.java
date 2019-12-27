package charactor;

import property.Item;

public class Hero extends Object{

    public  String name; //姓名

    public float hp; //血量

    float armor; //护甲
    public float damage ;//伤害
    int moveSpeed = 100; //移动速度

    public Hero(String name, float hp, float damage) {
        this.name=name;
        this.hp=hp;
        this.damage=damage;
    }

    @Override
    public String toString() {
        return "Hero[" +
                "name='" + name + '\'' +
                ", hp=" + hp +
                ", damage=" + damage +
                ']'+"\n";
    }

    public void useItem(Item i){
        System.out.println("hero use item");
        i.effect();
    }

    public Hero(){
        System.out.println("Hero的无参的构造方法 ");
    }
    public Hero(String name,float hp){
        this.name = name;
        this.hp = hp;
    }
    public Hero(String name){
        this.name = name;
        System.out.println("Hero有一个参数的构造方法 "+this.name);
    }

    public static void main(String[] args) {
        Hero h = new Hero();
        h.name = "盖伦";
        System.out.println(h.toString());
        //直接打印对象就是打印该对象的toString()返回值
        System.out.println(h);
    }

    public float getHp() {
        return hp;
    }
}