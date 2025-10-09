package service;
import entity.Produto;

import java.io.OutputStream;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ecomerceservice {

    private static final Logger logger = Logger.getLogger(Ecomerceservice.class.getName());
    private List<Produto> produtoslist;

    public Ecomerceservice() {

    }
    public Ecomerceservice(List<Produto> produtos) {
        this.produtoslist = produtos;

        Logger rootLogger = Logger.getLogger("");
        rootLogger.setLevel(Level.ALL);

        for (var handler : rootLogger.getHandlers()) {
            rootLogger.removeHandler(handler);
        }

        ConsoleHandler handler = new ConsoleHandler() {
            @Override
            protected synchronized void setOutputStream(OutputStream out) throws SecurityException {
                super.setOutputStream(System.out);
            }
        };
        handler.setLevel(Level.ALL);
        rootLogger.addHandler(handler);
    }



    public void addProduto(Produto produto) {
        logger.info("\u001B[32m[INFO] Opcao de adicionar produtos\u001B[0m");

            try (Scanner sc = new Scanner(System.in)) {
                getMessage(new Scanner(System.in), "Quantos produtos deseja inserir");
                int quantidadeProdutos = sc.nextInt();
                sc.nextLine();
                for (int i = 0; i <= quantidadeProdutos; i++) {

                    System.out.println("\n--- " + i + "º Livro ---");

                    String nome = getMessage(sc, "Nome do produto:");
                    int quantidade = getIntMessage(sc, "Quantidade do produto:");
                    double preco = getDoubleMessage(sc, "Preco do produto:");

                    produtoslist.add(new Produto(nome, quantidade, preco) {
                    });
                }

            } catch (InputMismatchException e){
                logger.severe("\u001B[31m[ERROR] Entrada invalida. Por favor, insira os dados corretamente: " + e.getMessage() + "\u001B[0m");
                e.printStackTrace();
            } catch (Exception e) {
                logger.severe("\u001B[31m[ERROR] Erro ao adicionar produtoss: " + e.getMessage() + "\u001B[0m");
            }
    }
    public String getMessage(Scanner sc, String mensagem){
        System.out.println(mensagem);
        return sc.nextLine();
    }

    public int getIntMessage(Scanner sc, String mensagem){
        while (true){
        try {
            System.out.println(mensagem);
            int value = Integer.parseInt(sc.nextLine());
            return value;
        } catch (NumberFormatException e) {
            sc.nextLine();
            System.out.println("Entrada invalida. Por favor, insira um numero inteiro.");
        }

    }
    }

    public double getDoubleMessage(Scanner sc, String mensagem){
        while (true){
            try {
                System.out.println(mensagem);
                double value = Double.parseDouble(sc.nextLine());
                return value;
            } catch (NumberFormatException e) {
                sc.nextLine();
                System.out.println("Entrada invalida. Por favor, insira um numero decimal.");
            }

        }
    }

}
