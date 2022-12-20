package aula01.contrato;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Contrato {

    private int numero;
    private LocalDate data;
    private BigDecimal valorTotal;

    private List<Parcela> parcelas;

    public Contrato(LocalDate data, BigDecimal valorTotal) {
        this.data = data;
        this.valorTotal = valorTotal;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public LocalDate getData() {
        return data;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public List<Parcela> getParcelas() {
        return parcelas;
    }

    public void setParcelas(List<Parcela> parcelas) {
        this.parcelas = parcelas;
    }
}
