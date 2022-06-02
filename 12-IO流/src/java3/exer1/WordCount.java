package java3.exer1;

import org.junit.Test;

import java.io.*;
import java.util.*;


/**
 * 练习3:获取文本上字符出现的次数,把数据写入文件
 *
 * 思路：
 * 1.遍历文本每一个字符
 * 2.字符出现的次数存在Map中
 *
 * Map<Character,Integer> map = new HashMap<Character,Integer>();
 * map.put('a',18);
 * map.put('你',2);
 *
 * 3.把map中的数据写入文件
 *
 * @author shkstart
 * @create 2019 下午 3:47
 */
public class WordCount {
    /*
    说明：如果使用单元测试，文件相对路径为当前module
          如果使用main()测试，文件相对路径为当前工程
     */
    @Test
    public void testWordCount() throws IOException {
        //1.创建存放数据的集合
        HashMap<Character, Integer> map = new HashMap<>();

        //2.读取文本，进行统计存放到集合中
        BufferedReader br = new BufferedReader(new FileReader("dbcp.txt"));
        int str;
        while ((str = br.read()) != -1){
            char ch = (char)str;
            if(map.get(ch) == null){ //说明集合中没有此字符
                map.put(ch,1);
            }else{ //集合中已经存在此字符
                map.put(ch,map.get(ch)+1);
            }
        }

        //3.按集合中的value进行排序
        Set<Map.Entry<Character, Integer>> entries = map.entrySet();
        ArrayList<Map.Entry<Character, Integer>> list = new ArrayList<>(entries);
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return -Integer.compare(o1.getValue(), o2.getValue());
            }
        });

        //4. 创建输出流到文件
        BufferedWriter bw = new BufferedWriter(new FileWriter("WordCount.txt"));
        Iterator<Map.Entry<Character, Integer>> iterator = entries.iterator();
        int count = 0;
        while (iterator.hasNext() && count <= 10){
            Map.Entry<Character, Integer> next = iterator.next();
            switch (next.getKey()){
                case ' ':
                    bw.write("空格="+next.getValue());
                    break;
                case '\t': //tab键
                    bw.write("tab键="+next.getValue());
                    break;
                case '\r':
                    bw.write("回车="+next.getValue());
                    break;
                case '\n': //tab键
                    bw.write("换行="+next.getValue());
                    break;
                default:
                    bw.write(next.getKey()+"="+next.getValue());
            }
            count++;
            bw.newLine();
        }


        //5.关闭流




    }
}
