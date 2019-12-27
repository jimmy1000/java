package collection;

import java.util.HashMap;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        HashMap<String,String> hash = new HashMap<>();
        HashMap<String, String> map = new HashMap<String, String>();
        hash.put("adc","物理英雄");
        hash.put("apc","魔法英雄");
        hash.put("t","坦克");
        Set<String> key = hash.keySet();
        for (String s : key) {
            String values = hash.get(s);
            map.put(values, s);
            System.out.println(s);
        }

    }
}
