# Questionário — Algoritmo de Ford-Fulkerson (Grupo 3)

**Link do formulário (Google Forms):** [INSERIR_LINK_DO_FORMS_AQUI]

---

## Questões Fechadas

### 1. Sobre o papel do grafo residual e das arestas no sentido contrário no algoritmo de Ford-Fulkerson, é correto afirmar que:
- [ ] a) As arestas no sentido contrário servem apenas para representar tubulações ou vias de mão dupla no grafo original.
- [x] b) As arestas no sentido contrário representam a possibilidade de desfazer parte de um fluxo já enviado, permitindo reorganizar os caminhos para alcançar uma solução melhor.
- [ ] c) O grafo residual contém apenas as arestas cuja capacidade total já foi completamente preenchida.
- [ ] d) A busca por caminhos aumentantes é feita no grafo original, usando o grafo residual apenas para calcular a conservação de fluxo.

**Gabarito:** B — *Conforme o resumo teórico do grupo, as arestas reversas permitem desfazer parte de um fluxo já enviado e reorganizar os caminhos para encontrar a solução máxima.*

---

### 2. De acordo com o Teorema do Fluxo Máximo e Corte Mínimo, em uma rede de fluxo com origem e destino:
- [ ] a) O fluxo máximo será sempre menor que a capacidade de qualquer corte que separe a origem do destino.
- [ ] b) O corte mínimo corresponde ao menor número de arestas que precisam ser removidas para desconectar a origem do destino, sem considerar suas capacidades.
- [x] c) O maior fluxo possível entre a origem e o destino é igual à capacidade do corte mínimo da rede, e é atingido quando não existem mais caminhos aumentantes no grafo residual.
- [ ] d) Nos vértices intermediários, a quantidade de fluxo que sai pode ser maior que a quantidade que entra para compensar os gargalos.

**Gabarito:** C — *O teorema estabelece que o fluxo máximo iguala a capacidade do corte mínimo, o que ocorre exatamente quando não há mais caminhos aumentantes no grafo residual.*

---

### 3. Sobre a complexidade e o comportamento do algoritmo de Ford-Fulkerson clássico (com busca em profundidade — DFS):
- [ ] a) Garante tempo polinomial $O(V \times E^2)$ mesmo quando as capacidades das arestas são números irracionais.
- [x] b) Com capacidades inteiras, possui complexidade $O(E \times F)$, dependendo diretamente do valor do fluxo máximo $F$; já com capacidades irracionais, certas escolhas de caminhos podem fazer o algoritmo não terminar.
- [ ] c) A escolha entre busca em profundidade (DFS) e busca em largura (BFS) não altera a complexidade nem o número de iterações do algoritmo.
- [ ] d) O algoritmo encerra imediatamente após encontrar o primeiro gargalo da rede.

**Gabarito:** B — *Na implementação clássica com DFS, a complexidade $O(E \times F)$ depende do valor do fluxo máximo $F$ e pressupõe capacidades inteiras (podendo não terminar com capacidades irracionais).*

---
## Questões Abertas

### 4. Explique, com suas palavras, o que aconteceria se o algoritmo de Ford-Fulkerson fosse executado sem as arestas no sentido contrário no grafo residual. Por que elas são necessárias para encontrar o fluxo máximo?
**Gabarito esperado:** Sem as arestas no sentido contrário, o algoritmo não teria como desfazer ou redirecionar parte de um fluxo já enviado por um caminho escolhido anteriormente[cite: 1]. Assim, o algoritmo ficaria preso a escolhas iniciais subótimas, encerrando a execução assim que acabassem os caminhos diretos disponíveis e retornando um fluxo menor que o fluxo máximo real da rede[cite: 1].

---

### 5. Por que o algoritmo de Edmonds-Karp substitui a busca em profundidade (DFS) do Ford-Fulkerson clássico pela busca em largura (BFS) ao procurar caminhos aumentantes?
**Gabarito esperado:** Porque a busca em largura (BFS) procura primeiro os caminhos aumentantes com a **menor quantidade de arestas** entre a origem e o destino no grafo residual[cite: 1]. Isso evita que o algoritmo dependa de escolhas arbitrárias de caminhos quando as capacidades são muito grandes, garantindo uma complexidade polinomial de $O(V \times E^2)$ independentemente dos valores das capacidades[cite: 1].