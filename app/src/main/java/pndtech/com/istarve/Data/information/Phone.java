package pndtech.com.istarve.Data.information;

import pndtech.com.istarve.Util.Formats;

public class Phone {
    private int id;
    private String ddd;
    private String numberPhone;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    @Override
    public String toString() {
        return Formats.phone(this);
    }
}
