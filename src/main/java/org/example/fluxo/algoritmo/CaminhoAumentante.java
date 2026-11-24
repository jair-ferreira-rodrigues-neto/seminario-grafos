package org.example.fluxo.algoritmo;

import java.util.Collections;
import java.util.List;

public record CaminhoAumentante(List<String> caminho) {

    public CaminhoAumentante(List<String> caminho) {
        if (caminho == null || caminho.isEmpty()) {
            throw new IllegalArgumentException("Caminho nao pode ser vazio.");
        }
        this.caminho = Collections.unmodifiableList(caminho);
    }

}