package org.example.fluxo.algoritmo;

import java.util.Collections;
import java.util.List;

public record CaminhoAumentante(List<String> caminho, int gargalo) {

    public CaminhoAumentante(List<String> caminho, int gargalo) {
        if (caminho == null || caminho.isEmpty()) {
            throw new IllegalArgumentException("Caminho nao pode ser vazio.");
        }
        if (gargalo <= 0) {
            throw new IllegalArgumentException("Gargalo deve ser maior que zero.");
        }
        this.caminho = Collections.unmodifiableList(caminho);
        this.gargalo = gargalo;
    }

}