import entity.Produto;
import service.Ecomerceservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Cria o serviço de e-commerce
        Ecomerceservice ecomerceservice = new Ecomerceservice();

        // Adiciona produtos
        ecomerceservice.addProduto();

        // Exibe a lista de produtos (você precisa implementar este método)
        ecomerceservice.getProdutoslist();
    }
}
