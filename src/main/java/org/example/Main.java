package org.example;

import org.example.fluxo.algoritmo.FordFulkerson;
import org.example.fluxo.algoritmo.ResultadoFluxo;
import org.example.fluxo.exemplo.RedeDeDistribuicaoDeAgua;
import org.example.fluxo.modelo.RedeDeFluxo;

public class Main {
    public static void main(String[] args) {
        RedeDeFluxo rede = RedeDeDistribuicaoDeAgua.criar();
        System.out.printf("Distribuição de água do %s ao %s (L/s)%n%n",
                rede.getFonte(), rede.getDestino());

        ResultadoFluxo resultado = new FordFulkerson().executar(rede);
        resultado.registroExecucao().imprimir();

        System.out.println("\nFluxo final por tubulação (fluxo / capacidade):");
        for (String origem : rede.getVertices()) {
            for (String destino : rede.getVizinhos(origem)) {
                int fluxo = resultado.fluxosPorAresta().get(origem).get(destino);
                int capacidade = rede.getCapacidade(origem, destino);
                System.out.printf("  %s -> %s: %d / %d L/s%n", origem, destino, fluxo, capacidade);
            }
        }
        System.out.printf("%nO %s pode receber até %d L/s de água.%n",
                rede.getDestino(), resultado.fluxoMaximo());
    }
}
