package aula01.contrato;

import java.math.BigDecimal;

public class PayPal implements Pagamento {

    private static final BigDecimal PORCENTAGEM_TAXA =
            new BigDecimal(0.035);

    private static final BigDecimal PORCENTAGEM_JURO_MENSAL =
            new BigDecimal(0.049);

    @Override
    public BigDecimal calcularTaxaDePagamento(BigDecimal valor) {
        return valor.multiply(PORCENTAGEM_TAXA);
    }

    @Override
    public BigDecimal calcularJurosDaParcela(BigDecimal valor, int parcela) {
        BigDecimal parcelaEmBD = new BigDecimal(String.valueOf(parcela));
        return valor.multiply(PORCENTAGEM_JURO_MENSAL.multiply(parcelaEmBD));
    }
}
