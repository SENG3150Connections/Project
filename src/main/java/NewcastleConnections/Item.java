package NewcastleConnections;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Item {

    private String id, title, location, imagePath;
    private List<String> description;
    private BigDecimal price;
    private String type; // Valid types: event, accommodation, transport

    private List<String> tags;

    Item() {
        id = "";
        title = "";
        description = new ArrayList<>();
        location = "";
        price = new BigDecimal("0.0");
        imagePath = "";
        tags = new ArrayList<>();
        type = "event";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getDescription() {
        return description;
    }

    public String getSmallDescription() {
        return description.get(0);
    }

    public void setDescription(List<String> description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = new BigDecimal(price);
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public List<String> getTags() {
        return tags;
    }

    public void addTag(String tag) {
        this.tags.add(tag);
    }

    public void removeTag(String tag) {
        this.tags.remove(tag);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}