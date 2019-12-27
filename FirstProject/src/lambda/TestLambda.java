package lambda;

import charactor.Hero;

class TestLambda {
    public static boolean testHero(Hero h) {
        return h.hp>100 && h.damage<50;
    }
}
