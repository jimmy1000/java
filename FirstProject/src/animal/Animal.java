package animal;

public abstract class Animal {
    private int legs;


    public  abstract void eat();
    protected  Animal(int legs){
        this.legs = legs;
    }
    public void walk( ){
        System.out.println("此动物是"+this.legs+"腿行走的");
    }
}
