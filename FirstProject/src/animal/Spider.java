package animal;

public class Spider extends Animal {

    public Spider(int legs) {
        super(legs);
    }
    @Override
    public void eat() {
        System.out.println("蜘蛛吃虫子");
    }
    public static void main(String[] args) {
        Spider spider = new Spider(8) ;
        spider.walk();
        spider.eat();
    }


}
