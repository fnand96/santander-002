package aula01.contrato;

import java.math.BigDecimal;

public interface Pagamento {

    BigDecimal calcularTaxaDePagamento(BigDecimal valor);
    BigDecimal calcularJurosDaParcela(BigDecimal valor, int parcela);

}
