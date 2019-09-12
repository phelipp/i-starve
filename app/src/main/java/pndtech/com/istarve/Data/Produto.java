package pndtech.com.istarve.Data;

import java.io.Serializable;

import pndtech.com.istarve.Util.Formats;

public class Produto implements Serializable {
    private int id;
    private String name;
    private float value;
    private String description;
    private String imageUrl;

    public Produto() {
    }

    public Produto(int id) {
        this.id = id;
    }

    public Produto(int id, String name, float value, String imageUrl,String description) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.imageUrl = imageUrl;
        this.description=description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getValue() {
        return value;
    }

    public String getValueCurrency() {
        return Formats.currency(value);
    }

    public void setValue(float value) {
        this.value = value;
    }

    public void setValue(String value) {
        this.value = Float.parseFloat(value);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
