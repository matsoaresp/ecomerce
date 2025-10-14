package entity;

public class Utencilios extends Produto{

    public Utencilios(String nome, int quantidade, double preco) {
        super(nome, quantidade, preco);
    }

    public Utencilios() {
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Utencilios = " +" Nome: "+getNome() + " Preço: "+ getPreco() + " Quantidade: "+ getQuantidade());
    }

}
