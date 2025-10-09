package entity;

public class Roupas extends Produto{

    public Roupas(String nome, int quantidade, double preco) {
        super(nome, quantidade, preco);
    }

    public Roupas() {
    }

    @Override
    public String toString() {
        return "Roupas = "+ " Nome: "+getNome() + " Preço: "+ getPreco() + " Quantidade: "+ getQuantidade();
    }
}
