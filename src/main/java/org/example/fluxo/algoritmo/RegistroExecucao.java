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

    public String formatar() {
        StringBuilder saida = new StringBuilder();
        saida.append("========== Execucao do Ford-Fulkerson ==========\n");
        for (Iteracao iteracao : iteracoes) {
            saida.append("\n");
            saida.append("Iteracao ").append(iteracao.getNumero()).append("\n");
            saida.append(String.format("  %-17s %s%n", "Caminho:", String.join(" -> ", iteracao.getCaminho())));
            saida.append(String.format("  %-17s %d%n", "Gargalo:", iteracao.getGargalo()));
            saida.append(String.format("  %-17s %d%n", "Fluxo acumulado:", iteracao.getFluxoAcumulado()));
        }
        if (finalizado) {
            saida.append("\n");
            saida.append("Nao ha mais caminho aumentante da fonte ao destino.\n");
            saida.append("Fluxo maximo: ").append(getFluxoMaximo()).append("\n");
        }
        saida.append("================================================\n");
        return saida.toString();
    }

    public void imprimir() {
        System.out.print(formatar());
    }
}
