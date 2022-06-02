package exer1;

/**
 * @author huyongkun
 * @ClassName MyDate
 * @create 2022-05-17 12:51
 * @Version 1.0
 * @description: TODO
 */
public class MyDate implements Comparable<MyDate>{
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }

    @Override
    public int compareTo(MyDate o) {
        //比较年
        int a =this.year - o.year;
        if(a!=0){
            return a;
        }
        //比较月
        int b = this.month - o.month;
        if(b != 0){
            return b;
        }
        //比较日
        return this.day - o.day;
    }
}
