package aula01.database;

import java.util.Random;

public class GeradorDeNumerosAleatorio implements GeradorDeIdContrato {

    public String gerar() {
        int i = new Random().nextInt(1000);
        return String.format("%d-%d", i, System.currentTimeMillis());
    }
}
