package thread;

import property.Test;

public class TestThread {
    public static void main(String[] args) {

        TestHero gareen = new TestHero();
        gareen.name = "盖伦";
        gareen.hp = 616;
        gareen.damage = 50;

        TestHero teemo = new TestHero();
        teemo.name = "提莫";
        teemo.hp = 300;
        teemo.damage = 30;

        TestHero bh = new TestHero();
        bh.name = "赏金猎人";
        bh.hp = 500;
        bh.damage = 65;

        TestHero leesin = new TestHero();
        leesin.name = "盲僧";
        leesin.hp = 455;
        leesin.damage = 80;

        //单线程
        //盖伦攻击提莫
//        while (!teemo.isDead()) {
//            gareen.attackHero(teemo);
//        }
//        //赏金猎人攻击盲僧
//        while (!leesin.isDead()) {
//            bh.attackHero(leesin);
//        }

        //多线程
        //盖伦打提莫
//        KillThread killThread1 = new KillThread(gareen,teemo);
//        killThread1.start();

        //赏金打瞎子
//        KillThread killThread2 = new KillThread(bh,leesin);
//        killThread2.start();
        //使用runnable接口启动多线程
        Battle  battle1 = new Battle(gareen,teemo);
        new Thread(battle1).start();
        Battle battle2 = new Battle(bh,leesin);
        new Thread(battle2).start();



        //使用匿名类启动多线程
        Thread t1 = new Thread(){
            public void  run(){
                while(!teemo.isDead()){
                    gareen.attackHero(teemo);
                }
            }
        };

        Thread t2 = new Thread(){
            public void  run(){
                while(!leesin.isDead()){
                    Thread.yield();
                    bh.attackHero(leesin);
                }
            }
        };
        t1.setPriority(5);
        t2.setPriority(5);
        t1.start();
        t2.start();
    }
}
