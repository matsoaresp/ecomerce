package service;
import entity.Produto;
import entity.Roupas;
import utils.LoggerUtils;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

import static utils.InputUtils.*;

public class RoupasService {

    private static final Logger logger = Logger.getLogger(RoupasService.class.getName());
    private final List<Roupas> roupasList;

    public RoupasService() {
        LoggerUtils.staticLoggerUtils();
        this.roupasList = new ArrayList<>();
    }

    public void adicionarRoupas() {

        try  {
            Scanner sc = new Scanner(System.in);
            if (roupasList == null || roupasList.isEmpty()) {
                logger.warning("\u001B[33m[WARNING] A lista de roupas esta vazia.\u001B[0m");
            } else {
                logger.warning("\u001B[33m[WARNING] A lista de roupas ja possui itens.\u001B[0m");
            }
            int quantidadeRoupas = sc.nextInt();
            sc.nextLine();
            for(int i = 1; i <= quantidadeRoupas; i++) {
                System.out.println("\n--- " + i + "º Eletronico ---");
                String nome = getMessage(sc,"Insira o nome do Roupa ");
                int quantidade = getIntMessage(sc,"Insira a quantidade do Roupa ");
                double preco = getDoubleMessage(sc,"Informe o valor do Roupa ");
                roupasList.add(new Roupas (nome,quantidade,preco));
            }
        }catch (InputMismatchException e) {
            logger.severe("\u001B[31m[ERROR] Entrada invalida. Por favor, insira os dados corretamente: " + e.getMessage() + "\u001B[0m");
        }catch (Exception e ) {
            logger.severe("Erro ao adicionar roupas.");
        }
    }

    public List<Roupas> getRoupas() {

        if (roupasList == null || roupasList.isEmpty()) {
            logger.warning("\u001B[33m[WARNING] Nenhuma roupa no sistema.\u001B[0m");
        }else {
            logger.info("\u001B[32m[INFO] Lista de roupas obtida com sucesso.\u001B[0m");
        }
        for(Roupas roupa : roupasList) {
            roupa.exibirDetalhes();
        }
        return roupasList;
    }
}
