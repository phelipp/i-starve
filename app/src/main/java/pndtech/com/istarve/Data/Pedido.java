package pndtech.com.istarve.Data;

import java.util.Calendar;
import java.util.List;

import pndtech.com.istarve.Data.client.Cliente;

public class Pedido {
    private int id;
    private int idCart;
    private Calendar data;
    private Cliente cliente;
    private List<Item> itens;
    private float valorTotal;
    private String description;
    private ModoPagamento modoPagamento;



}
