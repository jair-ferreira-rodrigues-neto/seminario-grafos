package org.example.fluxo.exemplo;

import org.example.fluxo.modelo.RedeDeFluxo;

public class RedeDeDistribuicaoDeAgua {
    public static RedeDeFluxo criar() {
        RedeDeFluxo rede = new RedeDeFluxo();
        String reservatorio = "Reservatório";
        String estacaoNorte = "Estação Norte";
        String estacaoSul = "Estação Sul";
        String bairro = "Bairro Central";

        rede.adicionarVertice(reservatorio);
        rede.adicionarVertice(estacaoNorte);
        rede.adicionarVertice(estacaoSul);
        rede.adicionarVertice(bairro);
        rede.setFonte(reservatorio);
        rede.setDestino(bairro);

        rede.adicionarAresta(reservatorio, estacaoNorte, 8);
        rede.adicionarAresta(reservatorio, estacaoSul, 4);
        rede.adicionarAresta(estacaoNorte, bairro, 5);
        rede.adicionarAresta(estacaoNorte, estacaoSul, 3);
        rede.adicionarAresta(estacaoSul, bairro, 8);
        return rede;
    }
}
