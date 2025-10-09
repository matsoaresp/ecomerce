package service;

import entity.Eletronico;
import entity.Produto;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

import static utils.InputUtils.*;

public class Ecomerceservice {

    private static final Logger logger = Logger.getLogger(Ecomerceservice.class.getName());
    private final List<Produto> produtoslist;

    public Ecomerceservice() {
        this.produtoslist = new ArrayList<>();
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

        } catch (Exception e) {
            logger.severe("\u001B[31m[ERROR] Erro ao adicionar produtos: " + e.getMessage() + "\u001B[0m");

        }
    }
    public List<Produto> getProdutos() {
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






}
