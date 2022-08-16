import org.junit.Test;

/**
 * @author huyongkun
 * @ClassName index1
 * @create 2022-06-22 15:43
 * @Version 1.0
 * @description: TODO
 */
public class index1 {
    @Test
    //冒泡排序
    public void test1(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            boolean flag = true;
            for (int j = 0; j < arr.length-i-1; j++) {
                if(arr[j+1] < arr[j]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                    flag = false;
                }
            }
            if(flag){
                break;
            }
        }
    }


    //选择排序
    @Test
    public void test2(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i+1; j < arr.length-1; j++) {
                if(arr[j] < arr[min]){
                    min = j;
                }
            }

            if(min != i){
                int tmp = arr[i];
                arr[i] = arr[min];
                arr[min] = tmp;
            }
        }
    }

    //二分查找
    @Test
    public int test3(int[] arr, int m){
        int left = 0;
        int right = arr.length-1;
        while (right >= left){
            int middle = (left + right)/2;
            if(arr[middle] > m){
                right = middle-1;
            }else if(arr[middle] < m){
                left = middle +1;
            }else{
                return middle;
            }
        }
        return -1;
    }


    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader scl = ClassLoader.getSystemClassLoader();
        Class clazz = scl.loadClass("com.hu.jdbc.exer.BBB");
        System.out.println(clazz);
    }

    @Test
    public void test4() throws ClassNotFoundException {

    }




}
