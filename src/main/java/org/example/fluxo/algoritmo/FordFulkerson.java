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
        if (rede.getFonte() == null || rede.getDestino() == null) {
            throw new IllegalStateException("Fonte e destino devem estar definidos na rede.");
        }
        if (rede.getFonte().equals(rede.getDestino())) {
            return new ResultadoFluxo(0, construirMapaFluxosVazio(rede));
        }

        GrafoResidual grafoResidual = new GrafoResidual(rede);
        int fluxoMaximo = 0;

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

            fluxoMaximo += gargalo;
        }

        Map<String, Map<String, Integer>> fluxos = calcularFluxosFinais(rede, grafoResidual);
        return new ResultadoFluxo(fluxoMaximo, fluxos);
    }

    private Map<String, Map<String, Integer>> construirMapaFluxosVazio(RedeDeFluxo rede) {
        Map<String, Map<String, Integer>> fluxos = new HashMap<>();
        for (String u : rede.getVertices()) {
            fluxos.put(u, new HashMap<>());
            for (String v : rede.getVizinhos(u)) {
                fluxos.get(u).put(v, 0);
            }
        }
        return fluxos;
    }

    private Map<String, Map<String, Integer>> calcularFluxosFinais(RedeDeFluxo rede, GrafoResidual grafoResidual) {
        Map<String, Map<String, Integer>> fluxos = new HashMap<>();
        for (String u : rede.getVertices()) {
            fluxos.put(u, new HashMap<>());
            for (String v : rede.getVizinhos(u)) {
                int fluxoAresta = grafoResidual.getFluxo(u, v);
                fluxos.get(u).put(v, fluxoAresta);
            }
        }
        return fluxos;
    }
}