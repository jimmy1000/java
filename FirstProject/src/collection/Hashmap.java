package collection;
import java.util.HashMap;
import java.util.zip.DeflaterInputStream;

public class Hashmap {
    public static void main(String[] args) {
        HashMap<String,String> dictionary = new HashMap<>();
        dictionary.put("adc","物理英雄");
        dictionary.put("apc","魔法英雄");
        System.out.println(dictionary.get("adc"));
    }
}
