package animal;
public class Cat extends Animal implements Pet {
    String  name;
    public Cat(String name) {
        super(4);
        this.name=name;
    }
    public Cat(){
        this("");
    }

    public void getName(){
        System.out.println(this.name);
    };
    public void setName(String name){

    };
    public void play(){};
    @Override
    public void eat() {

    }

}
