package charactor;

public class ADHero extends Hero implements AD{

    int moveSpeed=400; //移动速度

    @Override
    public void physicAttack() {
        System.out.println("进行物理攻击");
    }

    public int getMoveSpeed(){
        return this.moveSpeed;
    }

    public int getMoveSpeed2(){
        return super.moveSpeed;
    }

    public static void main(String[] args) {
        ADHero h= new ADHero();
        System.out.println(h.getMoveSpeed());
        System.out.println(h.getMoveSpeed2());
    }

}