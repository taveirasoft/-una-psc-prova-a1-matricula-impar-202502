Maria Vitoria Taveira Mota - RA32510973

import java.util.Scanner;

public class calcularTaxaReducao {

    // Requisito 1: Cálculo da taxa de redução
    public static double calcularTaxaReducao(int populacaoInicial, int populacaoAtual) {
        double taxaReducao = (1 - ((double) populacaoAtual / populacaoInicial)) * 100;
        return taxaReducao;
    }

    // Requisito 2: Verificação de risco crítico
    public static boolean estaEmRiscoCritico(double taxaReducao) {
        return taxaReducao >= 90.0;
    }

    // Requisito 3: Simulação de abates futuros
    public static int simularImpactoAbate(int populacaoAtual, int abatesAnuais, int anosSimulados) {
        int populacaoRestante = populacaoAtual - (abatesAnuais * anosSimulados);
        return populacaoRestante;
    }

    // Requisito 4: Exibição de mensagem final
    public static void exibirDeclaracaoFinal(int populacaoRestante, int anos) {
        System.out.println("\n--- RESULTADO DA SIMULAÇÃO ---");
        if (populacaoRestante <= 0) {
            System.out.println("Atenção! A população de jumentos será extinta em " + anos + " anos se o ritmo atual continuar.");
        } else {
            System.out.println("População restante após " + anos + " anos: " + populacaoRestante + " jumentos.");
            System.out.println("Ainda há esperança! Iniciativas de conservação são vitais.");
        }
        System.out.println("\nPrograma de Monitoramento Finalizado.");
    }

    // Método principal
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Dados fornecidos
        int populacaoInicial = 1400000;
        int populacaoAtual = 84000;
        int abatesAnuais = 50000;

        System.out.println("=== S.O.S. JUMENTO NORDESTINO - SISTEMA DE MONITORAMENTO ===\n");

        System.out.println("População inicial de referência: " + populacaoInicial);
        System.out.println("População atual estimada: " + populacaoAtual);
        System.out.println("Abates anuais (simulados): " + abatesAnuais);

        // Chamada da função para calcular taxa de redução
        double taxaReducao = calcularTaxaReducao(populacaoInicial, populacaoAtual);
        System.out.printf("\n[Análise Inicial] Taxa de Redução Histórica: %.2f%%\n", taxaReducao);

        // Verificação do risco
        boolean riscoCritico = estaEmRiscoCritico(taxaReducao);
        if (riscoCritico) {
            System.out.println("[Status] Espécie em Risco CRÍTICO (Redução > 90%)!");
        } else {
            System.out.println("[Status] Espécie ainda está fora do risco crítico.");
        }

        // Perguntar ao usuário quantos anos deseja simular
        System.out.print("\nQuantos anos futuros você deseja simular o impacto dos abates (Ex: 1, 3, 5)? ");
        int anosSimulados = scanner.nextInt();

        // Simular impacto
        int populacaoRestante = simularImpactoAbate(populacaoAtual, abatesAnuais, anosSimulados);

        // Exibir resultado final
        exibirDeclaracaoFinal(populacaoRestante, anosSimulados);

        // Fechar o scanner
        scanner.close();
    }
}
