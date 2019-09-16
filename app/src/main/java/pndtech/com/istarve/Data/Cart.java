package pndtech.com.istarve.Data;

import java.io.Serializable;
import java.util.List;

import pndtech.com.istarve.Data.percistence.ObjectPercistence;

public class Cart implements ObjectPercistence {
    private int id;
    private List<Pedido> produtos;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Pedido> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Pedido> produtos) {
        this.produtos = produtos;
    }
}
