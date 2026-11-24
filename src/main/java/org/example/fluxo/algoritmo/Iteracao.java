package org.example.fluxo.algoritmo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Iteracao {
    private final int numero;
    private final List<String> caminho;
    private final int gargalo;
    private final int fluxoAcumulado;

    public Iteracao(int numero, List<String> caminho, int gargalo, int fluxoAcumulado) {
        this.numero = numero;
        this.caminho = Collections.unmodifiableList(new ArrayList<>(caminho));
        this.gargalo = gargalo;
        this.fluxoAcumulado = fluxoAcumulado;
    }

    public int getNumero() {
        return numero;
    }

    public List<String> getCaminho() {
        return caminho;
    }

    public int getGargalo() {
        return gargalo;
    }

    public int getFluxoAcumulado() {
        return fluxoAcumulado;
    }
}
