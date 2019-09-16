package pndtech.com.istarve.Data.client;

import pndtech.com.istarve.Data.percistence.ObjectPercistence;

public class Address implements ObjectPercistence {
    private int id;
    private Cliente cliente;
    private String street,
            number,
            neighborhood,
            city,
            zipCode;
    private State state;
}
