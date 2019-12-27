package charactor;

public class ADAPHero extends Hero implements Mortal{
    public void die() {
        System.out.println("进行魔法攻击");
    }
    public void physicAttack() {
        System.out.println("进行物理攻击");
    }
}
