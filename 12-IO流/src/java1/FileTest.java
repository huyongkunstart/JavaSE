package java1;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**file类的使用
 *
 * 1.file类的一个对象，代表一个文件或一个文件目录（文件夹）
 * 2.file类声明在java.io包下
 *
 *
 * @author hu
 * @create 2022-01-23 10:29
 */
public class FileTest {
    @Test
    public void tets1(){
        //File构造器1
        File file1 = new File("hello.txt");
        File file2 = new File("C:\\Users\\hu\\Desktop\\大数据学习\\he.txt");
        System.out.println(file1);
        System.out.println(file2);
        //File构造器2
        File file3 = new File("C:\\Users\\hu\\Desktop","javafile");
        System.out.println(file3);
        //File构造器3
        File file4 = new File(file3,"a.txt");
        System.out.println(file4);

    }

    //File常用方法

/*   1.File类的获取功能
 public String getAbsolutePath()：获取绝对路径
 public String getPath() ：获取路径
 public String getName() ：获取名称
 public String getParent()：获取上层文件目录路径。若无，返回null
 public long length() ：获取文件长度（即：字节数）。不能获取目录的长度。
 public long lastModified() ：获取最后一次的修改时间，毫秒值
下面两个方法适用文件目录
 public String[] list() ：获取指定目录下的所有文件或者文件目录的名称数组
 public File[] listFiles() ：获取指定目录下的所有文件或者文件目录的File数组*/
    @Test
    public void test2(){
        File file = new File("hello.txt");
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getPath());
        System.out.println(file.getName());
        System.out.println(file.getParent());
        System.out.println(file.length());
        System.out.println(file.lastModified());

        System.out.println("***********************************");
        File file1 = new File("E:\\Desktop");
        String[] list = file1.list();
        for(String a : list){
            System.out.println(a);
        }
        System.out.println("***********************************");
        File[] files = file1.listFiles();
        for(File a : files){
            System.out.println(a);
        }
    }
    /*
        2.File类的重命名功能
 public boolean renameTo(File dest):把文件重命名为指定的文件路径
    比如file1.renameTo(file2)
    要想保证返回true，file1在硬盘中存在，file2在硬盘中不存在
    */
    @Test
    public void test3(){
        File file1 = new File("D:\\workspace-idea\\java基础\\12-IO流\\hello.txt");
        File file2 = new File("D:\\workspace-idea\\java基础\\12-IO流\\hi.txt");
        boolean b = file1.renameTo(file2);
        System.out.println(b);
    }

    /*3.File类的判断功能
 public boolean isDirectory()：判断是否是文件目录
 public boolean isFile() ：判断是否是文件
 public boolean exists() ：判断是否存在
 public boolean canRead() ：判断是否可读
 public boolean canWrite() ：判断是否可写
 public boolean isHidden() ：判断是否隐藏*/
    @Test
    public void test4(){
        File file = new File("bucunzai.txt"); //不存在
        File file1 = new File("hi.txt"); //存在
        File file2 = new File("E:\\workspace-idea\\java基础"); //存在

        System.out.println(file.isDirectory());
        System.out.println(file.isFile());
        System.out.println(file.exists());
        System.out.println(file.canRead());
        System.out.println(file.canWrite());
        System.out.println(file.isHidden());
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");

        System.out.println(file1.isDirectory());
        System.out.println(file1.isFile());
        System.out.println(file1.exists());
        System.out.println(file1.canRead());
        System.out.println(file1.canWrite());
        System.out.println(file1.isHidden());

        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");

        System.out.println(file2.isDirectory());
        System.out.println(file2.isFile());
        System.out.println(file2.exists());
        System.out.println(file2.canRead());
        System.out.println(file2.canWrite());
        System.out.println(file2.isHidden());

    }

    /*
    4.File类的创建功能
 public boolean createNewFile() ：创建文件。若文件存在，则不创建，返回false
 public boolean mkdir() ：创建文件目录。如果此文件目录存在，就不创建了。
    如果此文件目录的上层目录不存在，也不创建。
  public boolean mkdirs() ：创建文件目录。如果上层文件目录不存在，一并创建
    注意事项：如果你创建文件或者文件目录没有写盘符路径，那么，默认在项目
    路径下。*/
    @Test
    public void test5() throws IOException {
        //文件的创建和删除
        File file = new File("hu.txt");
        if(!file.exists()){//文件不存在
            file.createNewFile();
            System.out.println("创建成功");
        }else{ //文件存在
            file.delete();
            System.out.println("删除成功");
        }

        //目录的创建和删除
        File file1 = new File("E:\\Desktop\\java创建目录");
        boolean mkdir = file1.mkdir();
        if(mkdir){
            System.out.println("创建成功");
        }


    }








}
