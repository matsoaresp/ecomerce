package service;
import entity.Eletronico;
import utils.LoggerUtils;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

import static utils.InputUtils.*;

public class EletronicoService {

    private static final Logger logger = Logger.getLogger(EletronicoService.class.getName());
    private final List<Eletronico> eletronicosList;

    public EletronicoService() {
        this.eletronicosList = new ArrayList<>();
        LoggerUtils.staticLoggerUtils();
    }

    public void adicionarEletronico() {
        try  {
            Scanner sc = new Scanner(System.in);
            logger.info("\u001B[32m[INFO] Opcao de adicionar eletronicos\u001B[0m");
            System.out.println("Quantos eletronicos deseja inserir?");
            int quantidadeEletronicos = sc.nextInt();
            sc.nextLine();
            for(int i = 1; i <= quantidadeEletronicos; i++) {
                System.out.println("\n--- " + i + "º Eletronico ---");
                String nome = getMessage(sc,"Qual o nome do eletronico?");
                int quantidade = getIntMessage(sc,"Qual a quantidade do eletronico?");
                double preco = getDoubleMessage(sc,"Qual o preco do eletronico?");
                sc.nextLine();

                eletronicosList.add(new Eletronico(nome, quantidade, preco));
            }
        } catch (InputMismatchException e ){
            logger.severe("\u001B[31m[ERROR] Entrada invalida. Por favor, insira os dados corretamente: " + e.getMessage() + "\u001B[0m");
        } catch (Exception e) {
            logger.severe("\u001B[31m[ERROR] Erro ao adicionar eletronicos: " + e.getMessage() + "\u001B[0m");
        }
    }

    public List<Eletronico> getEletronicosList(){
        if (eletronicosList == null || eletronicosList.isEmpty()){
            logger.warning("\u001B[33m[WARNING] A lista de eletronicos esta vazia.\u001B[0m");
        } else {
            logger.info("\u001B[32m[INFO] Lista de eletronicos obtida com sucesso.\u001B[0m");
        }
        for(Eletronico eletronico : eletronicosList){
            eletronico.exibirDetalhes();
        }
        return eletronicosList;
    }
}
