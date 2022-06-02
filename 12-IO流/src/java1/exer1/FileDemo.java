package java1.exer1;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author hu
 * @create 2022-01-23 14:53
 */
public class FileDemo {
    @Test
    public void test1() throws IOException {
        /*利用File构造器，new 一个文件目录file
        1)在其中创建多个文件和目录
        2)编写方法，实现删除file中指定文件的操作*/
        File file = new File("E:\\Desktop\\java_io_test");
        boolean mkdir = file.mkdir();
        if (mkdir){
            System.out.println("文件夹创建成功");
        }

        for (int i = 0; i < 10; i++) {
            String str = "hahaha"+i+".txt";
            File file1 = new File(file,str);
            boolean newFile = file1.createNewFile();
            if(newFile){
                System.out.println(str+"文件创建成功");
            }
        }
//        deletefile(new File(file,"hahaha2.txt"));

    }
    public void deletefile(File file){
        if(file.exists()){
            boolean delete = file.delete();
            if(delete){
                System.out.println(file.getName()+" 删除成功");
            }
        }else {
            System.out.println("要删除的文件不存在");
        }
    }

    @Test
    public void test2(){
        //判断指定目录下是否有后缀名为.jpg的文件，如果有，就输出该文件名称
        File file = new File("C:\\Users\\hu\\Desktop");
        String[] list = file.list();
        for(String a : list){
            if(a.endsWith(".jpg")){
                System.out.println(a);
            }
        }
    }

    @Test
    public void test3(){
        /*遍历指定目录所有文件名称，包括子文件目录中的文件。
        拓展1：并计算指定目录占用空间的大小
        拓展2：删除指定文件目录及其下的所有文件*/

        File file = new File("E:\\Desktop\\java_io_test");
        //遍历指定目录所有文件名称，包括子文件目录中的文件。
        System.out.println("占用空间为:"+printfiles(file));

    }
    public static int printfiles(File dir){
        File[] files = dir.listFiles();
        int sum = 0;
        for(File f : files){
            if(f.isDirectory()){
                sum += printfiles(f);
            }else {
                sum += f.length();
            }
        }
        return sum;

    }






}
