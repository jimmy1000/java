package collection;

import java.nio.file.NotDirectoryException;
import java.util.ArrayList;
import java.util.List;

public class Node {
    public Node  leftNode;
    public Node  rightNode;
    public Object value;
    public void add(Object v){
        if (value == null){
            value = v;
        }else{
            if ((Integer)v - ((Integer)value) <= 0 ){
                if (leftNode == null)
                    leftNode = new Node();
                leftNode.add(v);
            }else{
                if (rightNode == null)
                    rightNode = new Node();
                rightNode.add(v);
            }
        }
    }
    public List<Object> values(){
        List<Object> values = new ArrayList<>();
        // 左节点的遍历结果
        if (null != leftNode)
            values.addAll(leftNode.values());
        // 当前节点
        values.add(value);
        // 右节点的遍历结果
        if (null != rightNode)
            values.addAll(rightNode.values());
        return values;
    }

    public static void main(String[] args) {
        int  data[] = new int[]{69,12,45,103,217,55};
        Node roots = new Node();
        for (int number:data){
            roots.add(number);
        }
        System.out.println(roots.values());
    }
}
