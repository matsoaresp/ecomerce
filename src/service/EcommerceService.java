package service;
import entity.Produto;
import utils.LoggerUtils;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;



public class EcommerceService {

    private static final Logger logger = Logger.getLogger(EcommerceService.class.getName());
    private final List<Produto> produtoslist;
    private final EletronicoService eletronico = new EletronicoService();
    private final RoupasService roupas = new RoupasService();
    private final UtensiliosService utensilios = new UtensiliosService();

    public EcommerceService() {
        LoggerUtils.staticLoggerUtils();
        this.produtoslist = new ArrayList<>();
    }

    public void switchOption(Scanner sc) {
        try {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Adicionar Eletrônico");
            System.out.println("2 - Adicionar Roupas");
            System.out.println("3 - Adicionar Utensilios");
            System.out.print("Digite sua opção: ");

            int opcao = sc.nextInt();
            switch (opcao) {

                case 1:
                    eletronico.adicionarEletronico();
                    break;
                case 2:
                    roupas.adicionarRoupas();
                    break;
                case 3:
                    utensilios.adicionarUtencilios();
                    break;
                default:
                    logger.warning("Opção inválida. Tente novamente.");
                    break;
            }
        } catch (InputMismatchException e) {
            logger.severe("Erro ao selecionar opções " + e.getMessage());
            throw e;
        }catch (Exception e) {
            logger.severe("Erro no sistema" + e.getMessage());
            throw e;
        }
    }

    public void getProdutos(Scanner sc) {
        try {
            System.out.println("1 - Listar Eletrônicos");
            System.out.println("2 - Listar Roupas");
            System.out.println("3 - Listar Utensílios");
            System.out.print("Digite sua opção: ");

            int opcao = sc.nextInt();
            switch (opcao) {
                case 1:
                    eletronico.getEletronicosList();
                    break;
                case 2:
                    roupas.getRoupas();
                    break;
                case 3:
                    utensilios.getUtencilios();
                    break;
                    default:
                        logger.warning("Opção inválida. Tente novamente.");
                        break;
            }
        } catch (InputMismatchException e) {
            logger.severe("Erro ao selecionar opções " + e.getMessage());
        } catch (Exception e) {
            logger.severe("Erro no sistema" + e.getMessage());

        }
    }
    public void runApplication (){
        try{
            Scanner sc = new Scanner(System.in);
            switchOption(sc);
            getProdutos(sc);
        } catch(InputMismatchException e){
            logger.severe("Erro no sistema " + e.getMessage());
            System.exit(1);
        }


    }
}
