package thread;
public class Battle implements Runnable{
    private TestHero  hero1;
    private TestHero  hero2;

    public Battle(TestHero hero1, TestHero hero2) {
        this.hero1 = hero1;
        this.hero2 = hero2;
    }
    @Override
    public void run() {
        while(!hero2.isDead()){
            hero1.attackHero(hero2);
        }
    }
}
