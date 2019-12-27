package property;

public class Test {
    public static void main(String[] args) {
        new Item(){

            public void effect() {
                System.out.println("物品使用后，可以有效果 ");
            }
        };
    }
}
