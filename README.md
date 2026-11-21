# Fluxo Máximo em Redes: Ford-Fulkerson

Trabalho de seminário da disciplina **Teoria dos Grafos** (INF02016, 2026.2, T01) do IF Sudeste MG, Campus Juiz de Fora.

**Grupo 3:** Problema da Capacidade Máxima de uma Rede de Distribuição.

## Integrantes

- Guilherme de Almeida Oliveira
- Jair Ferreira Rodrigues Neto
- Sabrina Rodrigues Dias Roriz
- Rafaela Freitas Gomes
- Joseh Emannuel da Conceição
- Bernardo Oliveira Duarte

## O problema

Uma rede de tubulações (água), cabos (energia) ou enlaces (dados) possui uma capacidade máxima em cada trecho. Qual é o maior fluxo possível entre a fonte e o destino, sem violar nenhuma capacidade?

O problema é modelado como um grafo orientado, em que:

- cada vértice é um ponto da rede (fonte, destino ou nó intermediário);
- cada aresta orientada é um trecho com uma capacidade máxima;
- o objetivo é maximizar o fluxo que sai da fonte e chega ao destino, respeitando a capacidade das arestas e a conservação de fluxo nos nós intermediários.

## O algoritmo

O **algoritmo de Ford-Fulkerson** encontra o fluxo máximo repetindo três passos:

1. construir o grafo residual a partir do fluxo atual;
2. buscar um caminho aumentante da fonte ao destino no grafo residual;
3. enviar pelo caminho o valor do seu gargalo (menor capacidade residual) e atualizar o fluxo.

O algoritmo termina quando não existe mais caminho aumentante. O fluxo acumulado é, então, o fluxo máximo, e pelo teorema do fluxo máximo e corte mínimo ele é igual à capacidade do corte mínimo.

## Estrutura do projeto

```
src/
  main/java/fluxo/
    modelo/       rede de fluxo, vértices e arestas com capacidade
    algoritmo/    grafo residual, caminho aumentante e Ford-Fulkerson
    exemplo/      redes de exemplo e programa principal
  test/java/fluxo/
docs/
  fundamentos.md    resumo da teoria de fluxo máximo
  questionario.md   perguntas e gabarito do questionário
  slides/           apresentação em PowerPoint
```

## Como compilar e executar

As instruções serão adicionadas quando a implementação estiver pronta.

## Fluxo de trabalho

- Todo trabalho parte de uma **issue**, vinculada à milestone **Apresentação Ford-Fulkerson**.
- Cada issue tem uma branch própria no formato `<tag-da-issue>-<titulo-da-issue>`.
- Commits seguem `<tipo>: <assunto>`, com tipo entre `feat`, `fix`, `docs`, `style`, `refactor`, `test` e `chore`.
- Cada branch é integrada por Pull Request com título no padrão dos commits e descrição `Finalizando issue #<numero> <restante da descrição>`.
- Os PRs são revisados por outro integrante antes do merge na `main`.

## Entregáveis

- Apresentação de 20 a 30 minutos em PowerPoint, com o código mostrado e explicado.
- Implementação executável do algoritmo, com explicação do resultado.
- Questionário no Google Forms com 3 perguntas fechadas e 2 abertas, compartilhado com o professor.
- Envio na tarefa do SIGAA até 26/11/2026 às 23h59.