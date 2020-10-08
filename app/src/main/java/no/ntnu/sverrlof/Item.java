package no.ntnu.sverrlof;

public class Item {
    private int imageResource;
    private String headerView;
    private String descriptionView;

    public Item(int imageResource, String headerView, String descriptionView) {
        this.imageResource = imageResource;
        this.headerView = headerView;
        this.descriptionView = descriptionView;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public String getHeaderView() {
        return headerView;
    }

    public void setHeaderView(String headerView) {
        this.headerView = headerView;
    }

    public String getDescriptionView() {
        return descriptionView;
    }

    public void setDescriptionView(String descriptionView) {
        this.descriptionView = descriptionView;
    }
}
