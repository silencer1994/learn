package mycode.day08.bean;

/**
 * Created by ls on 17-7-5.
 * 电脑品牌的实体类
 */
public class Brand {
    private String name;
    private int surplusStock;
    private float price;

    public String toString() {
        return this.getName()+"     "+this.getSurplusStock()+"       "+this.getPrice()+"          "+this.getPrice()*this.getSurplusStock() ;
    }
    public Brand(String name, int surplusStock, float price) {
        this.name = name;
        this.surplusStock = surplusStock;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSurplusStock() {
        return surplusStock;
    }

    public void setSurplusStock(int surplusStock) {
        this.surplusStock = surplusStock;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
