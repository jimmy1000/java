package thread;

public class KillThread extends Thread {
    private  TestHero h1;
    private  TestHero h2;
    public KillThread(TestHero h1, TestHero h2){
        this.h1 = h1;
        this.h2 = h2;
    }
    public void run(){
        while(!h2.isDead()){
            h1.attackHero(h2);
        }
    }
}
