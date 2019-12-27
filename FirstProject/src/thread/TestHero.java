package thread;

public class TestHero {
    public String name;
    public float hp;
    public int damage;
    volatile public float maxHp = 1000f;
    volatile public float minHp = 1f;

    public synchronized void recover() {

        // 如果hp小于最大生命值,则hp+1
        if (hp < maxHp) {
            hp = hp + 1;
            System.out.printf("%s加血1点,加血后,%s的血量是%.0f%n", name, name, hp);
        } else {
            try {
                // 当hp等于最大生命值时,加血线程临时释放对this的占有,并等待
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();

            }
        }
    }

    public synchronized void hurt() {

        if(hp == minHp) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        hp = hp - 1;
        System.out.printf("%s减血1点,减血后,%s的血量是%.0f%n", name, name, hp);
        // 通知正在等待this的加血线程可以醒过来了
        this.notify();
    }
    public void attackHero(TestHero h) {
//        try {
//            //为了表示攻击需要时间，每次攻击暂停1000毫秒
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
        h.hp-=damage;
        System.out.format("%s 正在攻击 %s, %s的血变成了 %.0f%n",name,h.name,h.name,h.hp);

        if(h.isDead())
            System.out.println(h.name +"死了！");
    }

    public boolean isDead() {
        return 0>=hp?true:false;
    }

}
