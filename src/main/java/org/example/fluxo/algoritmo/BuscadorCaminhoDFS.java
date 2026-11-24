package org.example.fluxo.algoritmo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.example.fluxo.modelo.GrafoResidual;

public class BuscadorCaminhoDFS {

    public Optional<CaminhoAumentante> buscarCaminho(GrafoResidual grafo) {
        String fonte = grafo.getFonte();
        String destino = grafo.getDestino();

        Set<String> visitados = new HashSet<>();
        List<String> caminhoAtual = new ArrayList<>();

        boolean encontrou = dfs(grafo, fonte, destino, visitados, caminhoAtual);
        if (encontrou) {
            return Optional.of(new CaminhoAumentante(caminhoAtual));
        }

        return Optional.empty();
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
}