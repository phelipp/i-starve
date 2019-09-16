package pndtech.com.istarve.Data.client;

import pndtech.com.istarve.Data.percistence.ObjectPercistence;

public class Phone implements ObjectPercistence {

    private int id;
    private Cliente cliente;
    private String ddd;
    private String number;

    public Phone() {
    }

    public Phone(int id, Cliente cliente, String ddd, String number) {
        this.id = id;
        this.cliente = cliente;
        this.ddd = ddd;
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
