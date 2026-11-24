package org.example.fluxo.algoritmo;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.example.fluxo.modelo.GrafoResidual;
import org.example.fluxo.modelo.RedeDeFluxo;

public class FordFulkerson {
    private final BuscadorCaminhoDFS buscador;

    public FordFulkerson() {
        this.buscador = new BuscadorCaminhoDFS();
    }

    public ResultadoFluxo executar(RedeDeFluxo rede) {
        if (rede == null) {
            throw new IllegalArgumentException("Rede de fluxo nao pode ser nula.");
        }

        GrafoResidual grafoResidual = new GrafoResidual(rede);

        while (true) {
            Optional<CaminhoAumentante> optCaminho = buscador.buscarCaminho(grafoResidual);
            if (optCaminho.isEmpty()) {
                break;
            }

            CaminhoAumentante caminhoAumentante = optCaminho.get();
            int gargalo = caminhoAumentante.gargalo();

            for (int i = 0; i < caminhoAumentante.caminho().size() - 1; i++) {
                String u = caminhoAumentante.caminho().get(i);
                String v = caminhoAumentante.caminho().get(i + 1);
                grafoResidual.aumentarFluxo(u, v, gargalo);
            }
        }

        return new ResultadoFluxo(0, new HashMap<>());
    }
}