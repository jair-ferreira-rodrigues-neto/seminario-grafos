package org.example.fluxo.modelo;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class GrafoResidual {
    private final RedeDeFluxo rede;
    private final Map<String, Map<String, Integer>> residual;

    public GrafoResidual(RedeDeFluxo rede) {
        if (rede == null) {
            throw new IllegalArgumentException("Rede de fluxo nao pode ser nula.");
        }
        this.rede = rede;
        this.residual = new HashMap<>();

        for (String vertice : rede.getVertices()) {
            residual.put(vertice, new HashMap<>());
        }
        for (String origem : rede.getVertices()) {
            for (String destino : rede.getVizinhos(origem)) {
                residual.get(origem).put(destino, rede.getCapacidade(origem, destino));
            }
        }
    }

    public String getFonte() {
        return rede.getFonte();
    }

    public String getDestino() {
        return rede.getDestino();
    }

    public Set<String> getVertices() {
        return rede.getVertices();
    }

    public Set<String> getVizinhos(String vertice) {
        if (!residual.containsKey(vertice)) {
            throw new IllegalArgumentException("Vertice nao encontrado.");
        }
        return Collections.unmodifiableSet(residual.get(vertice).keySet());
    }

    public int getCapacidadeResidual(String origem, String destino) {
        if (!residual.containsKey(origem) || !residual.containsKey(destino)) {
            throw new IllegalArgumentException("Vertice nao encontrado.");
        }
        return residual.get(origem).getOrDefault(destino, 0);
    }
}
