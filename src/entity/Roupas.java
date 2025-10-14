package entity;

public class Roupas extends Produto{

    public Roupas(String nome, int quantidade, double preco) {
        super(nome, quantidade, preco);
    }

    public Roupas() {
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Roupas = " +" Nome: "+getNome() + " Preço: "+ getPreco() + " Quantidade: "+ getQuantidade());
    }

}
