package date;

public class test {
    public static void main(String[] args) {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j+"x"+i+"="+i*j+"\t");
                //打印当符合进入外循环条件时，即当i= 几时i*j的值
            }
            System.out.println();//换行
        }
    }
}
