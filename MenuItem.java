public class MenuItem {

    private String desc; // unique
    private double price;
    private int prepTime; // minutes
    private String ingradients; // comma-separated list
    private String image_filename;

    public MenuItem(String desc, double price, int prepTime, String ingradients, String image_filename) {
        this.desc = desc;
        this.price = price;
        this.prepTime = prepTime;
        this.ingradients = ingradients;
        this.image_filename = image_filename;
    }

    public String getDesc() {
        return desc;
    }

    public Double getPrice() {
        return price;
    }

    public int getPrepTime() {
        return prepTime;
    }

    public String getIngradients() {
        return ingradients;
    }

    public String getImageFilename() {
        return image_filename;
    }
}
