package service;

import entity.Eletronico;
import entity.Produto;

import java.io.OutputStream;
import java.util.ArrayList;
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
        this.produtoslist = new ArrayList<>();

        // Configuração do logger
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

    public Ecomerceservice(List<Produto> produtos) {
        this.produtoslist = produtos;

        // Configuração do logger
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

    public void addProduto() {
        logger.info("\u001B[32m[INFO] Opcao de adicionar produtos\u001B[0m");

        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Quantos produtos deseja inserir?");
            int quantidadeProdutos = sc.nextInt();
            sc.nextLine();

            for (int i = 1; i <= quantidadeProdutos; i++) {
                System.out.println("\n--- " + i + "º Produto ---");

                String nome = getMessage(sc, "Nome do produto:");
                int quantidade = getIntMessage(sc, "Quantidade do produto:");
                double preco = getDoubleMessage(sc, "Preco do produto:");

                produtoslist.add(new Eletronico(nome, quantidade, preco));
            }

            logger.info("\u001B[32m[INFO] Produtos adicionados com sucesso!\u001B[0m");

        } catch (InputMismatchException e) {
            logger.severe("\u001B[31m[ERROR] Entrada invalida. Por favor, insira os dados corretamente: " + e.getMessage() + "\u001B[0m");
            e.printStackTrace();
        } catch (Exception e) {
            logger.severe("\u001B[31m[ERROR] Erro ao adicionar produtos: " + e.getMessage() + "\u001B[0m");
            e.printStackTrace();
        }
    }

    public List<Produto> getProdutoslist() {
        if (produtoslist == null || produtoslist.isEmpty()) {
            logger.warning("\u001B[33m[WARNING] A lista de produtos esta vazia.\u001B[0m");
        } else {
            logger.info("\u001B[32m[INFO] Lista de produtos obtida com sucesso.\u001B[0m");
        }

        System.out.println("Produtos da loja:");
        for (Produto produto : produtoslist) {
            System.out.println("Nome: " + produto.getNome() +
                    ", Quantidade: " + produto.getQuantidade() +
                    ", Preco: " + produto.getPreco());
        }
        return produtoslist;
    }

    public String getMessage(Scanner sc, String mensagem) {
        System.out.println(mensagem);
        return sc.nextLine();
    }

    public int getIntMessage(Scanner sc, String mensagem) {
        while (true) {
            try {
                System.out.println(mensagem);
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada invalida. Por favor, insira um numero inteiro.");
            }
        }
    }

    public double getDoubleMessage(Scanner sc, String mensagem) {
        while (true) {
            try {
                System.out.println(mensagem);
                String input = sc.nextLine().replace(",", ".");
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Entrada invalida. Por favor, insira um numero decimal.");
            }
        }
    }
}
