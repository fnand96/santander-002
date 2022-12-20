package aula01.contrato;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Parcela {

    private LocalDate data;
    private BigDecimal valor;

    public Parcela(LocalDate data, BigDecimal valor) {
        this.data = data;
        this.valor = valor;
    }

    public LocalDate getData() {
        return data;
    }

    public BigDecimal getValor() {
        return valor;
    }
}
