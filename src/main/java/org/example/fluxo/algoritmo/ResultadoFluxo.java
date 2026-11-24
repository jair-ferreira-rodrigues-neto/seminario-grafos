package org.example.fluxo.algoritmo;

import java.util.Collections;
import java.util.Map;

public record ResultadoFluxo(int fluxoMaximo, Map<String, Map<String, Integer>> fluxosPorAresta, RegistroExecucao registroExecucao) {
    public ResultadoFluxo(int fluxoMaximo, Map<String, Map<String, Integer>> fluxosPorAresta, RegistroExecucao registroExecucao) {
        this.fluxoMaximo = fluxoMaximo;
        this.fluxosPorAresta = Collections.unmodifiableMap(fluxosPorAresta);
        this.registroExecucao = registroExecucao;
    }
}