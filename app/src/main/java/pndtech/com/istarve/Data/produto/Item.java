package pndtech.com.istarve.Data.produto;

import java.io.Serializable;

public class Item implements Serializable {
    private int id;
    private int amount;
    private Produto produto;

    public Item() {
        produto = new Produto();
    }

    public Item(int id, int amount, Produto produto) {
        this.id = id;
        this.amount = amount;
        this.produto = produto;
    }

    public int getId() {
        return id;
    }


    public void setId(int id) {
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }



    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
