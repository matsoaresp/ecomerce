import entity.Produto;
import service.Ecomerceservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Ecomerceservice ecomerceservice = new Ecomerceservice();
        ecomerceservice.addProduto();
        ecomerceservice.getProdutoslist();
    }
}
