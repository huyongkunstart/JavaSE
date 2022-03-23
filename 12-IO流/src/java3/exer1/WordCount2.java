package java3.exer1;

import org.junit.Test;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * 自己手写一遍 统计文本字符出现次数 并进行排序，打印次数最多的10个字符
 * @author hu
 * @create 2022-01-25 10:41
 */
public class WordCount2 {
    @Test
    public void testWordCount() throws IOException {
        //1.存放次数的集合
        HashMap<Character, Integer> hashMap = new HashMap<>();

        //2.把读取的数据存放到集合中
        FileReader fr = new FileReader("dbcp.txt");
        int a = 0;
        while ((a = fr.read()) != -1){
            char ch = (char)a;
            if(hashMap.get(ch) == null){
                hashMap.put(ch,1);
            }else {
                hashMap.put(ch,hashMap.get(ch)+1);
            }
        }

        //3.把集合中的数据写入到文本中
        //3.1创建写入流对象
        BufferedWriter fw = new BufferedWriter(new FileWriter("WordCount.txt"));
        //3.2遍历hashmap集合，写入数据
        //对map集合按照value值从大到小排序
        ArrayList<Map.Entry<Character, Integer>> list = new ArrayList<>(hashMap.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return -o1.getValue().compareTo(o2.getValue());
            }
        });


        Iterator<Map.Entry<Character, Integer>> iterator = list.iterator();
        int count=0;//仅打印前10个出现次数多的
        while (iterator.hasNext() && count <10){
            Map.Entry<Character, Integer> next = iterator.next();
            switch (next.getKey()){
                case ' ':
                    fw.write("空格="+next.getValue());
                    break;
                case '\t': //tab键
                    fw.write("tab键="+next.getValue());
                    break;
                case '\r':
                    fw.write("回车="+next.getValue());
                    break;
                case '\n': //tab键
                    fw.write("换行="+next.getValue());
                    break;
                default:
                    fw.write(next.getKey()+"="+next.getValue());
                    break;
            }
            count++;
            fw.newLine();
        }

        //4.流的关闭
        if(fr != null){
            fr.close();
        }
        if(fw != null){
            fw.close();
        }



    }
}
