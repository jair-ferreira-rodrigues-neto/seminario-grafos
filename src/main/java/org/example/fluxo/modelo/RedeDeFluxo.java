package org.example.fluxo.modelo;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RedeDeFluxo {
    private final Set<String> vertices;
    private final Map<String, Map<String, Integer>> capacidades;
    private String fonte;
    private String destino;

    public RedeDeFluxo() {
        this.vertices = new HashSet<>();
        this.capacidades = new HashMap<>();
    }

    public void adicionarVertice(String vertice) {
        if (vertice == null || vertice.trim().isEmpty()) {
            throw new IllegalArgumentException("Vertice invalido.");
        }
        vertices.add(vertice);
        capacidades.putIfAbsent(vertice, new HashMap<>());
    }

    public void setFonte(String fonte) {
        if (!vertices.contains(fonte)) {
            throw new IllegalArgumentException("Vertice de fonte nao existe na rede.");
        }
        this.fonte = fonte;
    }

    public void setDestino(String destino) {
        if (!vertices.contains(destino)) {
            throw new IllegalArgumentException("Vertice de destino nao existe na rede.");
        }
        this.destino = destino;
    }

    public String getFonte() {
        return fonte;
    }

    public String getDestino() {
        return destino;
    }

    public Set<String> getVertices() {
        return Collections.unmodifiableSet(vertices);
    }

    public Set<String> getVizinhos(String vertice) {
        if (!vertices.contains(vertice)) {
            throw new IllegalArgumentException("Vertice nao encontrado.");
        }
        Map<String, Integer> vizinhos = capacidades.get(vertice);
        if (vizinhos == null) {
            return Collections.emptySet();
        }
        return Collections.unmodifiableSet(vizinhos.keySet());
    }

    public void adicionarAresta(String origem, String destino, int capacidade) {
        if (!vertices.contains(origem) || !vertices.contains(destino)) {
            throw new IllegalArgumentException("Vertices de origem e destino devem existir na rede.");
        }
        if (capacidade < 0) {
            throw new IllegalArgumentException("Capacidade nao pode ser negativa.");
        }
        capacidades.get(origem).put(destino, capacidade);
    }

    public int getCapacidade(String origem, String destino) {
        if (!vertices.contains(origem) || !vertices.contains(destino)) {
            throw new IllegalArgumentException("Vertice nao encontrado.");
        }
        Map<String, Integer> vizinhos = capacidades.get(origem);
        if (vizinhos == null) {
            return 0;
        }
        return vizinhos.getOrDefault(destino, 0);
    }
}