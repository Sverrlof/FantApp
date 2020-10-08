package no.ntnu.sverrlof.model;

public class Item {
    private int imageResource;
    private String itemName;
    private String descriptionView;
    private int price;

    public Item(int imageResource, String itemName, String descriptionView, int price) {
        this.imageResource = imageResource;
        this.itemName = itemName;
        this.descriptionView = descriptionView;
        this.price = price;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
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
                "imageResource=" + imageResource +
                ", itemName='" + itemName + '\'' +
                ", descriptionView='" + descriptionView + '\'' +
                ", price=" + price +
                '}';
    }
}
