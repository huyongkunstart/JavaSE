package java7;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**随机存取文件流
 * RandomAccessFile
 * 1.直接继承与java.lang.Object类，实现了DataInput 和 DataOutput接口
 * 2.RandomAccessFile既可以作为一个输入流，又可以作为一个输出流
 * 3.如果RandomAccessFile作为输出流时，写出到的文件如果不存在，则在执行过程中自动创建，
 *    如果写出到的文件存在，则会对原有文件内容进行覆盖。（默认情况下，从头覆盖）
 * 4.可以通过相关的操作，实现RandomAccessFile“插入”数据的效果
 * 
 * @author hu
 * @create 2022-01-26 14:18
 */
public class RandomAccessFileTest {
    @Test
    public void test1(){
        RandomAccessFile raf1 = null;
        RandomAccessFile raf2 = null;
        try {
            raf1 = new RandomAccessFile(new File("1.jpg"),"r");
            raf2 = new RandomAccessFile(new File("1-bat.jpg"), "rw");

            byte[] bytes = new byte[1024];
            int len;
            while ((len = raf1.read(bytes)) != -1){
                raf2.write(bytes,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(raf1 != null){
                try {
                    raf1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(raf2 != null){
                try {
                    raf2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

/*    如果RandomAccessFile作为输出流时，写出到的文件如果不存在，则在执行过程中自动创建，
      如果写出到的文件存在，则会对原有文件内容进行覆盖。（默认情况下，从头覆盖）*/
    @Test
    public void test2() throws IOException {
        RandomAccessFile raf = new RandomAccessFile("hello.txt", "rw");
        raf.seek(3);//将指针调到角标为3的位置（覆盖写入）
        //如果想在已有文件末尾追加，只需要raf.seek((new File("hello.txt")).length())
        raf.write("aaaa".getBytes());
        raf.close();
    }


    //使用RandomAccessFile实现数据的插入效果，而不是覆盖
    @Test
    public void test3() throws IOException {
        RandomAccessFile raf = new RandomAccessFile("hello.txt", "rw");

        raf.seek(3);

        //保存指针3后面所有数据到Stringbuilder中
        StringBuilder builder = new StringBuilder((int) new File("hello.txt").length());
        byte[] bytes = new byte[20];
        int len;
        while ((len = raf.read(bytes)) != -1){
            builder.append(new String(bytes,0,len));
        }

        //调回指针，写入"huhuhu"
        raf.seek(3);
        raf.write("huhuhu".getBytes());

        //将StringBuilder中的数据写入
        raf.write(builder.toString().getBytes());

        raf.close();
    }






}
