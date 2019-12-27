package property;

public class Item extends Object{
    String name;
    int price;
    public Item(){}
    public Item(String name){
        this.name=name;
    }
    public void buy(){
        System.out.println("购买");
    }
    public void effect() {
        System.out.println("物品使用后，可以有效果 ");
    }
    public String toString(){
        return name+price;
    }
    public void finalize(){
        System.out.println(this+"这个英雄正在被回收");
    }
    public  boolean equals(Object o){
        if(o instanceof Item){
            Item h = (Item) o;
            return this.price == h.price;
        }
        return false;
    }

    public static void main(String[] args) {

    }

}