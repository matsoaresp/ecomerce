
import service.Ecomerceservice;
import utils.LoggerUtils;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Ecomerceservice ecomerceservice = new Ecomerceservice();
        ecomerceservice.switchOption(sc);

    }
}
