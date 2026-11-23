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
        vertices.add(vertice);
        capacidades.putIfAbsent(vertice, new HashMap<>());
    }

    public void setFonte(String fonte) {
        this.fonte = fonte;
    }

    public void setDestino(String destino) {
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
        Map<String, Integer> vizinhos = capacidades.get(vertice);
        if (vizinhos == null) {
            return Collections.emptySet();
        }
        return Collections.unmodifiableSet(vizinhos.keySet());
    }

    public void adicionarAresta(String origem, String destino, int capacidade) {
        capacidades.get(origem).put(destino, capacidade);
    }

    public int getCapacidade(String origem, String destino) {
        Map<String, Integer> vizinhos = capacidades.get(origem);
        if (vizinhos == null) {
            return 0;
        }
        return vizinhos.getOrDefault(destino, 0);
    }
}