package charactor;
public class APHero extends Hero implements Mortal{
    public APHero(String name){
        this.name = name;
    }
    public void die() {
        System.out.println(this.name+"进行魔法攻击");
    }
}
