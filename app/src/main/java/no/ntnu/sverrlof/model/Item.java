package no.ntnu.sverrlof.model;

public class Item {

    private String item;
    private String description;
    private int price;
    private long itemid;


    public Item(String itemName, String descriptionView, int price) {
        this.item = itemName;
        this.description = descriptionView;
        this.price = price;
    }

/*    public Item(String itemName, String descriptionView, int price) {
        this.item = itemName;
        this.description = descriptionView;
        this.price = price;

    }*/

    public String getItemName() {
        return item;
    }

    public void setItemName(String headerView) {
        this.item = headerView;
    }

    public String getDescriptionView() {
        return description;
    }

    public void setDescriptionView(String descriptionView) {
        this.description = descriptionView;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public long getItemid() {
        return itemid;
    }


    @Override
    public String toString() {
        return "Item{" +
                ", itemName='" + item + '\'' +
                ", descriptionView='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
