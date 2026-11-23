package org.example.fluxo.modelo;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RedeDeFluxo {
    private final Set<String> vertices;
    private final Map<String, Set<String>> adjacencias;
    private String fonte;
    private String destino;

    public RedeDeFluxo() {
        this.vertices = new HashSet<>();
        this.adjacencias = new HashMap<>();
    }

    public void adicionarVertice(String vertice) {
        vertices.add(vertice);
        adjacencias.putIfAbsent(vertice, new HashSet<>());
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
        return Collections.unmodifiableSet(adjacencias.getOrDefault(vertice, Collections.emptySet()));
    }
}