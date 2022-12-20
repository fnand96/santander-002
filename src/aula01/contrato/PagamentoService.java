package aula01.contrato;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PagamentoService {

    private Pagamento pagamento;

    public PagamentoService(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public Contrato processarPagamento(Contrato contrato,
                                       int qtdParcelas) {

        contrato.setNumero(new Random().nextInt(1000));

        BigDecimal valorCadaParcela =
                contrato.getValorTotal().divide(new BigDecimal(qtdParcelas));

        List<Parcela> listaDeParcelas = new ArrayList<>();

        for (int i = 1; i <= qtdParcelas; i++) {

            BigDecimal taxaDaParcela =
                    pagamento.calcularTaxaDePagamento(valorCadaParcela);

            BigDecimal parcelaMaisTaxa = valorCadaParcela.add(taxaDaParcela);

            BigDecimal jurosDaParcela =
                    pagamento.calcularJurosDaParcela(parcelaMaisTaxa, i);

            BigDecimal valorTotalDaParcela = valorCadaParcela
                    .add(taxaDaParcela)
                    .add(jurosDaParcela);

            Parcela parcela =
                    new Parcela(LocalDate.now().plusMonths(i), valorTotalDaParcela);

            listaDeParcelas.add(parcela);
        }

        contrato.setParcelas(listaDeParcelas);

        return contrato;
    }

}
