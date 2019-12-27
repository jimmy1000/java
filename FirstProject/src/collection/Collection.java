package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Collection {
    public static void main(String[] args) {
        List<Integer> numbers  = new ArrayList<>();
        for (int i=0; i<10;i++){
            numbers.add(i);
        }
        System.out.println(numbers);
        int count=0;
        for (int i=0;i<1000000;i++){
            Collections.shuffle(numbers);
            if (numbers.get(0) == 3 && numbers.get(1) == 1 && numbers.get(2) == 4 ){
                count++;
            }
        }
        System.out.printf("结果为314的概率为:%s%s",count/10000.0,"%");
    }
}
