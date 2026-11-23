package org.example.fluxo.algoritmo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RegistroExecucao {
    private final List<Iteracao> iteracoes;
    private boolean finalizado;

    public RegistroExecucao() {
        this.iteracoes = new ArrayList<>();
        this.finalizado = false;
    }

    public void registrarIteracao(List<String> caminho, int gargalo, int fluxoAcumulado) {
        if (caminho == null || caminho.isEmpty()) {
            throw new IllegalArgumentException("Caminho da iteracao nao pode ser vazio.");
        }
        if (finalizado) {
            throw new IllegalStateException("Execucao ja foi finalizada.");
        }
        iteracoes.add(new Iteracao(iteracoes.size() + 1, caminho, gargalo, fluxoAcumulado));
    }

    public void registrarFim() {
        this.finalizado = true;
    }

    public boolean isFinalizado() {
        return finalizado;
    }

    public List<Iteracao> getIteracoes() {
        return Collections.unmodifiableList(iteracoes);
    }

    public int getFluxoMaximo() {
        if (iteracoes.isEmpty()) {
            return 0;
        }
        return iteracoes.get(iteracoes.size() - 1).getFluxoAcumulado();
    }
}
