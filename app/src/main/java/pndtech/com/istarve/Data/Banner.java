package pndtech.com.istarve.Data;

import pndtech.com.istarve.Data.percistence.ObjectPercistence;

public class Banner implements ObjectPercistence {
    private int id;
    private String urlImage;

    public Banner() {
    }

    public Banner(String urlImage) {
        this.urlImage = urlImage;
    }

    public Banner(int id, String urlImage) {
        this.id = id;
        this.urlImage = urlImage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }
}
