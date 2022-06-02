import java.util.Scanner;

/**
 * @author huyongkun
 * @ClassName CMUtility
 * @create 2022-05-14 13:49
 * @Version 1.0
 * @description: 工具类
 */
public class CMUtility {
    private static Scanner scanner = new Scanner(System.in);

    /*
     * @Author huyongkun
     * @Date 13:58 2022/5/14
     * @Param [limit, blankreturn]
     * @return java.lang.String
     * @Description // 获取指定limit长度的字符串
     **/
    private static String readKeyBoard(int limit,boolean blankreturn){
        String line = "";
        while (scanner.hasNextLine()){
            line = scanner.nextLine();
            if(line.length() == 0){
                if(blankreturn){
                    return line;
                }else {
                    continue;
                }
            }
            if(line.length() > limit){
                System.out.println("输入长度（不大于"+limit+"）错误，请重新输入:");
                continue;
            }
            break;
        }
        return line;
    }
    /*
     * @Author huyongkun
     * @Date 14:13 2022/5/14
     * @Param []
     * @return char
     * @Description //读取1~5中的任意字符
     **/
    public static char readMenuSelection(){
        char c;
        while (true){
            String str = readKeyBoard(1, false);
            c = str.charAt(0);
            if(c != '1' && c != '2' && c != '3' && c != '4' && c != '5'){
                System.out.println("选择错误，请重新选择:");
            }else {
                break;
            }
        }
        return c;
    }

    /*
     * @Author huyongkun
     * @Date 14:17 2022/5/14
     * @Param []
     * @return char
     * @Description //键盘读取一个字符，并作为返回值
     **/
    public static char readChar(){
        return readKeyBoard(1,false).charAt(0);
    }
    /*
     * @Author huyongkun
     * @Date 14:17 2022/5/14
     * @Param [defaultValue]
     * @return char
     * @Description //键盘读取一个字符，如果不输入字符，则将defaultvalue返回
     **/
    public static char readChar(char defaultValue){
        String s = readKeyBoard(0, true);
        return (s.length() == 0) ? defaultValue : s.charAt(0);
    }

    
    /*
     * @Author huyongkun
     * @Date 14:21 2022/5/14
     * @Param []
     * @return int
     * @Description //键盘获取一个不超过2位的整数，并将其返回
     **/
    public static int readInt(){
        int n;
        while (true){
            String str = readKeyBoard(2,false);
            try {
                n = Integer.parseInt(str);
                break;
            }catch (RuntimeException e){
                System.out.println("数字输入错误，请重新输入:");
            }
        }
        return n;

    }
    /*
     * @Author huyongkun
     * @Date 14:22 2022/5/14
     * @Param [defaultValue]
     * @return int
     * @Description //键盘获取一个不超过2位的整数，如果没有获取到，则将defaultValue返回
     **/
    public static int readInt(int defaultValue){
        int n;
        while (true){
            String str = readKeyBoard(2,true);
            if(str.length() == 0){
                return defaultValue;
            }else {
                try {
                    n = Integer.parseInt(str);
                    break;
                }catch (RuntimeException e){
                    System.out.println("数字输入错误，请重新输入:");
                }
            }
        }
        return n;
    }

    /*
     * @Author huyongkun
     * @Date 14:31 2022/5/14
     * @Param [limit]
     * @return java.lang.String
     * @Description //获取一个长度不超过limit的字符串并返回
     **/
    public static String readString(int limit){
        return readKeyBoard(limit,false);
    }
    /*
     * @Author huyongkun
     * @Date 14:31 2022/5/14
     * @Param [limit, defaultValue]
     * @return java.lang.String
     * @Description //获取一个长度不超过limit的字符串并返回,如果字符串为空，这将defaultValue返回
     **/
    public static String readString(int limit, String defaultValue){
        String str = readKeyBoard(limit,true);
        return (str.length() == 0) ? defaultValue:str;
    }

    /*
     * @Author huyongkun
     * @Date 14:36 2022/5/14
     * @Param []
     * @return char
     * @Description //键盘读取'Y'或 'N'，并返回
     **/
    public static char readConfirmSelection(){
        char c;
        while (true){
            c = readKeyBoard(1,false).toUpperCase().charAt(0);
            if(c == 'Y' || c == 'N'){
                break;
            }else {
                System.out.println("输入错误，请重新输入:");
            }
        }
        return c;


    }
}
