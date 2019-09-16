package pndtech.com.istarve.Data;

public enum ModoPagamento {
    CARD("Cartão de credito"),
    MONEY("Dinheiro");
    private String label;

    ModoPagamento(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
