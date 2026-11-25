package org.example.fluxo.algoritmo;

import java.util.List;
import org.example.fluxo.modelo.RedeDeFluxo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FordFulkersonTest {

    private final FordFulkerson algoritmo = new FordFulkerson();

    private RedeDeFluxo criarRede(String... intermediarios) {
        RedeDeFluxo rede = new RedeDeFluxo();
        rede.adicionarVertice("S");
        rede.adicionarVertice("T");
        for (String vertice : intermediarios) {
            rede.adicionarVertice(vertice);
        }
        rede.setFonte("S");
        rede.setDestino("T");
        return rede;
    }

    @Test
    void calculaFluxoMaximoConhecido() {
        RedeDeFluxo rede = criarRede("A", "B", "C", "D");
        rede.adicionarAresta("S", "A", 16);
        rede.adicionarAresta("S", "B", 13);
        rede.adicionarAresta("A", "B", 10);
        rede.adicionarAresta("B", "A", 4);
        rede.adicionarAresta("A", "C", 12);
        rede.adicionarAresta("C", "B", 9);
        rede.adicionarAresta("B", "D", 14);
        rede.adicionarAresta("D", "C", 7);
        rede.adicionarAresta("C", "T", 20);
        rede.adicionarAresta("D", "T", 4);

        assertEquals(23, algoritmo.executar(rede).fluxoMaximo());
    }

    @Test
    void limitaFluxoAoGargaloDoUnicoCaminho() {
        RedeDeFluxo rede = criarRede("A", "B");
        rede.adicionarAresta("S", "A", 8);
        rede.adicionarAresta("A", "B", 3);
        rede.adicionarAresta("B", "T", 5);

        ResultadoFluxo resultado = algoritmo.executar(rede);

        assertEquals(3, resultado.fluxoMaximo());
        assertEquals(3, resultado.fluxosPorAresta().get("S").get("A"));
        assertEquals(3, resultado.fluxosPorAresta().get("A").get("B"));
        assertEquals(3, resultado.fluxosPorAresta().get("B").get("T"));
    }

    @Test
    void retornaZeroQuandoDestinoEstaInalcancavel() {
        RedeDeFluxo rede = criarRede("A");
        rede.adicionarAresta("S", "A", 5);
        rede.adicionarAresta("T", "A", 5);

        ResultadoFluxo resultado = algoritmo.executar(rede);

        assertEquals(0, resultado.fluxoMaximo());
        assertTrue(resultado.registroExecucao().getIteracoes().isEmpty());
    }

    @Test
    void usaArestaReversaParaRedirecionarFluxo() {
        RedeDeFluxo rede = criarRede("A", "B");
        rede.adicionarAresta("S", "A", 1);
        rede.adicionarAresta("S", "B", 1);
        rede.adicionarAresta("A", "B", 1);
        rede.adicionarAresta("A", "T", 1);
        rede.adicionarAresta("B", "T", 1);

        ResultadoFluxo resultado = algoritmo.executar(rede);

        List<Iteracao> iteracoes = resultado.registroExecucao().getIteracoes();
        assertTrue(iteracoes.stream().anyMatch(i -> i.getCaminho().equals(List.of("S", "B", "A", "T"))));
        assertEquals(0, resultado.fluxosPorAresta().get("A").get("B"));
        assertEquals(2, resultado.fluxoMaximo());
    }

    @Test
    void retornaZeroQuandoFonteEDestinoCoincidem() {
        RedeDeFluxo rede = criarRede("A");
        rede.setDestino("S");
        rede.adicionarAresta("S", "A", 4);
        rede.adicionarAresta("A", "S", 4);

        ResultadoFluxo resultado = algoritmo.executar(rede);

        assertEquals(0, resultado.fluxoMaximo());
        assertEquals(0, resultado.fluxosPorAresta().get("S").get("A"));
        assertEquals(0, resultado.fluxosPorAresta().get("A").get("S"));
        assertTrue(resultado.registroExecucao().getIteracoes().isEmpty());
    }

    @Test
    void ignoraArestaDeCapacidadeZeroEUsaCaminhoDisponivel() {
        RedeDeFluxo rede = criarRede("A", "B");
        rede.adicionarAresta("S", "A", 6);
        rede.adicionarAresta("A", "T", 0);
        rede.adicionarAresta("S", "B", 4);
        rede.adicionarAresta("B", "T", 4);

        ResultadoFluxo resultado = algoritmo.executar(rede);

        assertEquals(4, resultado.fluxoMaximo());
        assertEquals(0, resultado.fluxosPorAresta().get("A").get("T"));
        assertEquals(4, resultado.fluxosPorAresta().get("B").get("T"));
    }
}
