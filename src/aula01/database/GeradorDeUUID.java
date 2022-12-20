package aula01.database;

import java.util.UUID;

public class GeradorDeUUID implements GeradorDeIdContrato {

    public String gerar() {
        String uid = UUID.randomUUID().toString();
        return uid;
    }
}
