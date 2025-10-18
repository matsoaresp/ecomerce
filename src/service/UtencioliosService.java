package service;

import entity.Utencilios;
import utils.LoggerUtils;
import utils.InputUtils;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

import static utils.InputUtils.*;

public class UtencioliosService {

    private static final Logger logger = Logger.getLogger(UtencioliosService.class.getName());
    private final List<Utencilios> utencilios;

    public UtencioliosService() {
        LoggerUtils.staticLoggerUtils();
        this.utencilios = new ArrayList<>();

    }

    public void adicionarUtencilios (){
        try{
            Scanner sc = new Scanner(System.in);
            System.out.println("Quantos produtos deseja adicionar?");
            int quantidadeUtencilios = sc.nextInt();
            sc.nextLine();
            for (int i = 0; i < quantidadeUtencilios; i++){
                String nome = getMessage(sc, "Informe o nome do produto: ");
                int quantidade = getIntMessage(sc, "Informe a quantidade do produto: ");
                double valor = getDoubleMessage(sc, "Informe o valor do produto: ");
                sc.nextLine();
                utencilios.add(new Utencilios(nome, quantidade, valor));
            }
        }catch (InputMismatchException e){
            logger.severe("\u001B[31m[ERROR] Entrada invalida. Por favor, insira os dados corretamente: " + e.getMessage() + "\u001B[0m");
        }catch (Exception e){
            logger.severe("\u001B[31m[ERROR] Erro ao adicionar utencilios" + e.getMessage() + "\u001B[0m");
        }

    }


    public List<Utencilios> getUtencilios(){

        try{
            if(utencilios.isEmpty() || utencilios == null){
                logger.warning("\u001B[33m[WARNING] A lista de eletronicos esta vazia.\u001B[0m");
            }else {
                logger.info("\u001B[32m[INFO] Lista de roupas obtida com sucesso.\u001B[0m");
            }
            for (Utencilios utencilio : utencilios){
                utencilio.exibirDetalhes();
            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
        return utencilios;
    }
}
