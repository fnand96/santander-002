package aula01.contrato;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // perguntar o valor do contrato
        // qtd de parcelas

        // processarContrato
        // mostar taxas

        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.print("Informe o valor do contrato: ");
        BigDecimal valorTotal = scanner.nextBigDecimal();

        System.out.printf("Informe a qtd de parcelas: ");
        int qtdParcelas = scanner.nextInt();

        Contrato contrato = new Contrato(LocalDate.now(), valorTotal);

        PagamentoService service = new PagamentoService(new PayPal());
        Contrato contratoProcessado =
                service.processarPagamento(contrato, qtdParcelas);

        System.out.println(".:: DADOS DO CONTRATO::.");
        System.out.println("Numero: " + contratoProcessado.getNumero());
        System.out.println("Valor: " + contratoProcessado.getValorTotal());
        System.out.println("Data: " + contratoProcessado.getData().format(formatador));
        System.out.println();
        System.out.println(".:: DADOS DAS PARCELAS::.");

        for (Parcela parcela : contratoProcessado.getParcelas()) {
            System.out.println(parcela.getData().format(formatador)+ " - " + String.format("%.2f", parcela.getValor()));
        }
        System.out.println();
        System.out.println(".:: FIMD DADOS DO CONTRATO::.");



        // crie um novo meio de pagamento com as seguintes taxas:
        // taxa do pagamento: 2%
        // juros mensal: 1%
    }
}
