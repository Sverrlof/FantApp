package no.ntnu.sverrlof.model;

public class Item {

    private String itemName;
    private String descriptionView;
    private int price;
    private long itemId;
    private boolean isSold;


    public Item(String itemName, String descriptionView, int price) {
        this.itemName = itemName;
        this.descriptionView = descriptionView;
        this.price = price;
    }

    public Item(String itemName, String descriptionView, int price, boolean isSold) {
        this.itemName = itemName;
        this.descriptionView = descriptionView;
        this.price = price;
        this.isSold = isSold;
    }

    public boolean isSold() {
        return isSold;
    }

    public void setSold(boolean sold) {
        isSold = sold;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String headerView) {
        this.itemName = headerView;
    }

    public String getDescriptionView() {
        return descriptionView;
    }

    public void setDescriptionView(String descriptionView) {
        this.descriptionView = descriptionView;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item{" +
                ", itemName='" + itemName + '\'' +
                ", descriptionView='" + descriptionView + '\'' +
                ", price=" + price +
                '}';
    }
}
