package entity;

public class Eletronico extends  Produto{

    public Eletronico(String nome, int quantidade, double preco) {
        super(nome, quantidade, preco);
    }

    public Eletronico() {
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Eletronico = " +" Nome: "+getNome() + " Preço: "+ getPreco() + " Quantidade: "+ getQuantidade());
    }


}
