package pndtech.com.istarve.Data.client;

import pndtech.com.istarve.Data.percistence.ObjectPercistence;

public class State implements ObjectPercistence {
    private int id;

    private String name;

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
}
