package charactor;

public interface AP {
    public void magicAttack();
    default public void attack(){
        System.out.println("魔法攻击");
    };
}
