import java.io.*;
import java.util.ArrayList;

/**
 * @author huyongkun
 * @ClassName FileUtil
 * @create 2022-06-22 19:16
 * @Version 1.0
 * @description: TODO
 */
//1、复制一个文件到另一个文件或文件夹中
//(1)	文件目的如果是一个文件夹则原名复制
//(2)	如果是一个文件那么直接进行重命名复制
//2、向一个文件中写入内容。可以选择是否续写。可以指定编码格式
//3、读取一个文档内的所有内容，并返回。可以指定编码格式
//4、复制一个文件夹内的所有内容至另一个文件夹中。
//(1)	传入的路径必须都是文件夹

public class FileUtil {
    private FileUtil() {};
    public static FileUtil getInstance = new FileUtil();

    /*
      1、复制一个文件到另一个文件或文件夹中
        (1)文件目的如果是一个文件夹则原名复制
        (2)如果是一个文件那么直接进行重命名复制
    */
    public void copy_file_to_file(String srcfile, String desfile) throws IOException{
        File src = new File(srcfile);
        File des = new File(desfile);
        if(src.isFile()){
            throw new RuntimeException("源文件不是一个文件");
        }
        if (des.isDirectory()){ //目的路径是一个文件夹
            des = new File(des,src.getName());
        }else if(! new File(des.getParent()).exists()){ //目的路径是文件，上级目录并且不存在
            throw new RuntimeException("目的路径不存在");
        }
        FileInputStream fis = new FileInputStream(src);
        FileOutputStream fos = new FileOutputStream(des);
        BufferedInputStream bis = new BufferedInputStream(fis);
        BufferedOutputStream bos = new BufferedOutputStream(fos);

        int len;
        byte[] bytes = new byte[1024];
        while ((len = bis.read()) != -1){
            bos.write(bytes,0,len);
        }
        bis.close();
        bos.close();
    }

    //2、向一个文件中写入内容。可以选择是否续写。可以指定编码格式
    public static void write_content(String path, boolean superaddition, String charsetName, String content) throws IOException {
        if(new File(path).isDirectory()){
            throw new RuntimeException("源路径不是一个文件");
        }
        FileOutputStream fos = new FileOutputStream(path, superaddition);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        OutputStreamWriter osw = new OutputStreamWriter(bos,charsetName);
        osw.write(content);
        osw.flush();
        osw.close();
    }
    //重载，默认不续写,编码为utf-8
    public static void write_content(String path,String content) throws IOException {
        write_content(path,false,"UTF-8",content);
    }
    //重载，默认编码为utf-8 指定续写
    public static void write_content(String path,boolean superaddition,String content) throws IOException {
        write_content(path,superaddition,"UTF-8",content);
    }
    //重载，指定编码，默认不续写
    public static void write_content(String path, String charsetName,String content) throws IOException {
        write_content(path,false,charsetName,content);
    }


    //3、读取一个文档内的所有内容，并返回。可以指定编码格式
    public static String read_content(String file,String charsetName) throws IOException{
        if(new File(file).isDirectory()){
            throw new RuntimeException("源路径不是一个文件");
        }
        FileInputStream fis = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(fis,charsetName);
        BufferedReader br = new BufferedReader(isr);
        StringBuilder sb = new StringBuilder();

        int len;
        char[] chars = new char[4096];
        while ((len = br.read(chars)) != -1){
            sb.append(new String(chars,0,len));
        }
        br.close();
        return sb.toString();
    }
    //读取文件，默认UTF-8编码
    public static String read_content(String file) throws IOException{
        return read_content(file,"UTF-8");
    }


    //4、复制一个文件夹内的所有内容至另一个文件夹中。
        //(1)	传入的路径必须都是文件夹
    public void copy_content_director(String srcfile, String desfile) throws IOException {
        File src = new File(srcfile);
        File des = new File(desfile);
        if(!src.isDirectory() && !des.isDirectory()){
            throw new RuntimeException("传入的路径必须都是文件夹");
        }
        File[] files = src.listFiles();
        for (File file : files) {
            if(file.isFile()){
                copy_file_to_file(src.getPath(),des.getPath());
            }else{
                File temp = new File(des,file.getName());
                temp.mkdirs();
                copy_content_director(file.getPath(),temp.getPath());
            }
        }
    }


}