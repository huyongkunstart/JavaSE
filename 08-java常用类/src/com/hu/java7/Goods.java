package com.hu.java7;

/**商品类
 * @author hu
 * @create 2021-12-03 18:56
 */
public class Goods  implements Comparable{
    private int price;
    private String name;

    public Goods(){

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

    //指明商品比较大小的方式：按照价格从低到高排序,价格一样再按照产品名称从低到高排序
    @Override
    public int compareTo(Object o) {
        if(o instanceof Goods){
            Goods goods = (Goods)o;
            //方式一
            if(this.price>goods.price){
                return 1;
            }else if(this.price<goods.price){
                return -1;
            }else{
                return this.name.compareTo(goods.name);
            }
            //方式二：
//            return Double.compare(this.price,goods.price);
        }
        throw new RuntimeException("传入的数据类型不一致");
    }
}
