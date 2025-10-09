
import service.Ecomerceservice;
import utils.LoggerUtils;


public class Main {
    public static void main(String[] args) {

        LoggerUtils.staticLoggerUtils();
        Ecomerceservice ecomerceservice = new Ecomerceservice();
        ecomerceservice.addProduto();
        ecomerceservice.getProdutos();
    }
}
