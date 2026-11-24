package org.example.fluxo.algoritmo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.example.fluxo.modelo.GrafoResidual;

public class BuscadorCaminhoDFS {

    public Optional<CaminhoAumentante> buscarCaminho(GrafoResidual grafo) {
        if (grafo == null) {
            throw new IllegalArgumentException("Grafo residual nao pode ser nulo.");
        }

        String fonte = grafo.getFonte();
        String destino = grafo.getDestino();

        if (fonte == null || destino == null) {
            throw new IllegalStateException("Fonte e destino devem estar definidos na rede.");
        }

        if (fonte.equals(destino)) {
            return Optional.empty();
        }

        Set<String> visitados = new HashSet<>();
        List<String> caminhoAtual = new ArrayList<>();

        boolean encontrou = dfs(grafo, fonte, destino, visitados, caminhoAtual);
        if (!encontrou) {
            return Optional.empty();
        }

        int gargalo = calcularGargalo(grafo, caminhoAtual);
        return Optional.of(new CaminhoAumentante(caminhoAtual, gargalo));
    }

    private boolean dfs(
            GrafoResidual grafo,
            String atual,
            String destino,
            Set<String> visitados,
            List<String> caminhoAtual
    ) {
        visitados.add(atual);
        caminhoAtual.add(atual);

        if (atual.equals(destino)) {
            return true;
        }

        for (String vizinho : grafo.getVizinhos(atual)) {
            int capacidadeResidual = grafo.getCapacidadeResidual(atual, vizinho);
            if (capacidadeResidual > 0 && !visitados.contains(vizinho)) {
                if (dfs(grafo, vizinho, destino, visitados, caminhoAtual)) {
                    return true;
                }
            }
        }

        caminhoAtual.removeLast();
        return false;
    }

    private int calcularGargalo(GrafoResidual grafo, List<String> caminho) {
        int gargalo = Integer.MAX_VALUE;
        for (int i = 0; i < caminho.size() - 1; i++) {
            String origem = caminho.get(i);
            String destino = caminho.get(i + 1);
            int cap = grafo.getCapacidadeResidual(origem, destino);
            gargalo = Math.min(gargalo, cap);
        }
        return gargalo;
    }
}