package com.TeamSchedule.zifuchuan;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
import java.util.*;

/**
 * @author shkstart
 * @create 2022-05-11 23:46
 * @description：  所有的时间类
 */
public class exer2 {
    //java.util.date类 重写了toString方法
    @Test
    public void test1(){
        //构造器1
        Date date = new Date();
        //常用方法 getTime   toString
        System.out.println(date.getTime()); //1652318183729
        System.out.println(date); //Thu May 12 09:16:23 CST 2022
        //构造器2
        Date date1 = new Date(1652318183729L);

        //java.sql.Date extends java.util.date
        //构造器 必须传值
        java.sql.Date date2 = new java.sql.Date(1652318183729L);
        //如何将java.util.Date对象转换为java.sql.Date
        java.sql.Date date3 = new java.sql.Date(date.getTime());
        //如何将java.sql.Date对象转换为java.util.Date
        Date date4 = (Date) date3;

        System.out.println(date4.getTime());
    }

    //时间日期格式化SimpleDateFormat
    @Test
    public void test2() throws ParseException {
        //默认格式化
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat();
        System.out.println(df.format(date)); //22-5-12 上午9:29

        //格式化的逆过程
        String a = "22-5-12 上午9:29";
        Date date1 = df.parse(a);
        System.out.println(date1);

        System.out.println("--------------------------------------------------");

        //指定格式的格式化过程
        SimpleDateFormat df2 = new SimpleDateFormat("G yyyy-MM-dd HH:mm:ss");
        System.out.println(df2.format(date));

        //格式化的逆过程
        String b = "公元 2022-05-12 09:33:39";
        Date date2 = df2.parse(b);
        System.out.println(date2);
    }

    //日历类 java.util.Calendar
    //一月是0 二月是1  周日是1 周一是2 周二是3
    @Test
    public void test3() throws ParseException {
        //1.实例化
        //方式一
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar);

        //方式二 子类实例化
        Calendar calendar1 = new GregorianCalendar();

        //2.常用方法
        //get()
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH)); //12
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR)); //132
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH)); //2
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK)); //5
        System.out.println(calendar.get(Calendar.MONTH)); //4
        System.out.println(calendar.get(Calendar.DATE)); //显示该月的一天。12
        System.out.println("-------------------------------------------------");
        //set()
        calendar.set(Calendar.DAY_OF_MONTH,15);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println("-------------------------------------------------");
        //add()
        calendar.add(Calendar.DAY_OF_MONTH,5);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println("-------------------------------------------------");
        //getTime()
        Date time = calendar.getTime();
        System.out.println(time);
        //setTime
        Date date = new Date(1652318183729L);
        calendar.setTime(date);

    }


    //jdk8以后新的日期时间类
    @Test
    public void test4(){
        //now() 获取当前的时间日期
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDate); //2022-05-12
        System.out.println(localTime); //13:30:39.072
        System.out.println(localDateTime); //2022-05-12T13:30:39.072

        System.out.println("********************************************************");

        //of()
        LocalDateTime localDateTime1 = LocalDateTime.of(2000, 2, 6, 12, 30);
        System.out.println(localDateTime1);

        System.out.println("********************************************************");

        //getXxx() 获取相关属性
        System.out.println(localDateTime.getDayOfMonth()); //12
        System.out.println(localDateTime.getDayOfWeek()); //THURSDAY
        System.out.println(localDateTime.getDayOfYear()); //132
        System.out.println(localDateTime.getMonth()); //MAY
        System.out.println(localDateTime.getMonthValue()); //5
        System.out.println(localDateTime.getHour()); //13
        System.out.println(localDateTime.getDayOfWeek().getValue()); //4

        System.out.println("********************************************************");

        //withXxx 体现不可变性，设置完属性，生成一个新的时间日期对象，不改变原来的时间日期
        System.out.println(localDateTime.withHour(20));
        System.out.println(localDateTime.getHour()); //13

        System.out.println("********************************************************");
        //加属性，同样不改变原来的对象
        LocalDateTime localDateTime2 = localDateTime.plusMonths(5);
        System.out.println(localDateTime2.getMonth().getValue()); //10

        System.out.println("********************************************************");
        //减属性，同样不改变原来的对象
        LocalDateTime localDateTime3 = localDateTime.minusMonths(8);
        System.out.println(localDateTime3.getMonthValue()); //9
    }


    @Test
    public void test5(){
        //格式化 DateTimeFormatter
        //方式1 预定义的标准格式 如：ISO_LOCAL_DATE_TIME,ISO_LOCAL_DATE,ISO_LOCAL_TIME
        /*
        ISO_LOCAL_DATE_TIME       2022-05-12T14:11:09.973
        ISO_LOCAL_DATE            2022-05-12
        ISO_LOCAL_TIME            14:12:28.296

        BASIC_ISO_DATE            20220512

        ISO_DATE_TIME             2022-05-12T14:13:56.158
        ISO_DATE                  2022-05-12
        ISO_TIME                  14:16:06.281

        ISO_WEEK_DATE             2022-W19-4
        */
        DateTimeFormatter dtf = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));

        //逆过程
        TemporalAccessor parse = dtf.parse("2000-02-06T14:11:09.973");
        System.out.println(parse); //{},ISO resolved to 2000-02-06T14:11:09.973
        System.out.println("*******************************************************************************");
        //方式2  本地化相关格式

//       (1) ofLocalizedDateTime():
//          FormatStyle.LONG、FormatStyle.MEDIU、FormatStyle.SHORT 、FormatStyle.FULL
//          注：适用于LocalDateTime
        //ofLocalizedDate
        DateTimeFormatter formatter1 = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
        DateTimeFormatter formatter2 = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
        DateTimeFormatter formatter3 = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
        DateTimeFormatter formatter4 = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        //格式化：日期-->字符串
        LocalDateTime localDateTime = LocalDateTime.now();
        String str1 = formatter1.format(localDateTime);
        String str2 = formatter2.format(localDateTime);
        String str3 = formatter3.format(localDateTime);
        String str4 = formatter4.format(localDateTime);
        System.out.println("格式化之前："+localDateTime);//2022-05-12T14:23:18.468
        System.out.println("格式化之后SHORT："+str1);//22-5-12
        System.out.println("格式化之后LONG："+str2);//2022年5月12日
        System.out.println("格式化之后MEDIUM："+str3);//2022-5-12
        System.out.println("格式化之后FULL："+str4);//2022年5月12日 星期四


        //解析：字符串-->日期
        TemporalAccessor parse1 = formatter1.parse("21-7-21");
        TemporalAccessor parse2 = formatter2.parse("2021年7月21日");
        TemporalAccessor parse3 = formatter3.parse("2021-7-21");

        System.out.println(parse1);//{},ISO resolved to 2021-07-21
        System.out.println(parse1);//{},ISO resolved to 2021-07-21
        System.out.println(parse3);//{},ISO resolved to 2021-07-21

        System.out.println("*******************************************************************************");
        //方式3 本地格式化
        //ofPattern
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm;ss");
        System.out.println(dateTimeFormatter.format(now)); //2022-05-12 02:29;17
    }

    @Test
    //java比较器
    public void test6(){
        Goods[] arr = new Goods[4];
        arr[0] = new Goods(99,"罗技");
        arr[1] = new Goods(45,"huipu");
        arr[3] = new Goods(45,"sanxing");
        arr[2] = new Goods(12,"小米");

//        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));


        //定制排序 按照价格从大到小排序，如果价格一样，按照名字从下到大排序
        Arrays.sort(arr, new Comparator<Goods>() {
            @Override
            public int compare(Goods o1, Goods o2) {
                    if(o1.getPrice() > o2.getPrice()){
                        return -1;
                    }else if(o1.getPrice() < o2.getPrice()){
                        return 1;
                    }else {
                        return o1.getName().compareTo(o2.getName());
                    }
            }

        });

        System.out.println(Arrays.toString(arr));

    }








}


class Goods implements Comparable{
    private int price;
    private String name;

    public Goods() {
    }

    public Goods(int price, String name) {
        this.price = price;
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "price=" + price +
                ", name='" + name + '\'' +
                '}';
    }
    @Override
    public int compareTo(Object o){
        if (o instanceof Goods){
            Goods goods = (Goods) o;
            if(this.price > goods.price){
                return 1;
            }else if(this.price < goods.price){
                return -1;
            }else {
                return this.name.compareTo(goods.name);
            }
        }
        throw new RuntimeException("输入的数据类型不一致");
    }


}
