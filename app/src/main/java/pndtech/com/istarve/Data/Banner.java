package pndtech.com.istarve.Data;

public class Banner {
    private int id;
    private String urlImage;

    public Banner() {
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
