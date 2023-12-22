package org.example;

public class Products {


    private  int id;

    private String mode;

    private  int price;

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int sid) {
        this.id = sid;
    }

    private  int discount;

    private  int rating;

public Products(int id , String mode , int price , int discount,int rating ){
    this.id = id;
    this.mode = mode;
    this.price = price;
    this.discount = discount;
    this.rating = rating;

}
public Products(int id , String mode , int price , int discount )
{
    setId(id);
    setMode(mode);
    setDiscount(discount);
    setPrice(price);

}




}
