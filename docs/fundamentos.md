# Fundamentos de Fluxo Máximo

## 1. Rede de Fluxo

Uma rede de fluxo é um grafo direcionado que representa o transporte de algum recurso entre diferentes pontos. Ela é formada por vértices e arestas, além de possuir uma origem e um destino.

A origem é o ponto onde o fluxo começa, enquanto o destino é onde ele deve chegar. As arestas representam os caminhos utilizados para transportar esse fluxo entre os pontos da rede.

Esse tipo de estrutura pode ser utilizado para representar situações como o transporte de água por tubulações, a distribuição de produtos ou o tráfego em uma rede.

## 2. Capacidade

A capacidade indica a quantidade máxima de fluxo que pode passar por uma aresta. Cada ligação da rede possui um limite que deve ser respeitado durante o transporte.

Por exemplo, se uma aresta possui capacidade igual a 10, significa que ela pode transportar, no máximo, 10 unidades de fluxo. Portanto, o fluxo enviado não pode ultrapassar esse valor nem ser negativo.

## 3. Conservação de Fluxo

A conservação de fluxo determina que, em um vértice intermediário, a quantidade de fluxo que entra deve ser igual à quantidade que sai.

Isso significa que o fluxo não pode simplesmente desaparecer ou surgir durante o percurso. Ele apenas passa pelos vértices até chegar ao destino.

A origem e o destino são exceções a essa regra: na origem, o fluxo é enviado para a rede e, no destino, ele é recebido.

## 4. Grafo Residual

O grafo residual mostra quanto ainda é possível aumentar ou modificar o fluxo em uma rede. Ele é construído considerando as capacidades que ainda estão disponíveis nas arestas.

Além dos caminhos que permitem enviar mais fluxo, o grafo residual também possui arestas no sentido contrário. Essas arestas representam a possibilidade de desfazer parte de um fluxo que já foi enviado, permitindo reorganizar os caminhos e encontrar uma solução melhor.

Esse conceito é importante para o funcionamento do algoritmo de Ford-Fulkerson, pois é por meio do grafo residual que são identificadas novas possibilidades de aumentar o fluxo.

## 5. Caminho Aumentante

Um caminho aumentante é um caminho que liga a origem ao destino e possui capacidade residual positiva em todas as suas arestas.

Quando esse caminho é encontrado, significa que ainda existe a possibilidade de enviar mais fluxo pela rede.

O algoritmo utiliza esses caminhos para aumentar o fluxo total. Depois de cada aumento, o grafo residual é atualizado e uma nova busca é realizada. Esse procedimento continua até que não seja mais possível encontrar um caminho aumentante.

## 6. Gargalo

O gargalo corresponde à menor capacidade residual entre todas as arestas de um caminho aumentante. Ele determina quanto de fluxo pode ser acrescentado naquele caminho.

Por exemplo, imagine um caminho com três arestas, cujas capacidades residuais sejam 8, 5 e 10 unidades. Nesse caso, o gargalo será 5, pois essa é a menor capacidade disponível.

Assim, mesmo que as outras arestas suportem uma quantidade maior, só será possível acrescentar 5 unidades de fluxo naquele caminho.

## 7. Corte Mínimo

Um corte representa uma divisão dos vértices da rede em dois grupos: um contendo a origem e outro contendo o destino.

A capacidade desse corte é calculada somando as capacidades das arestas que saem do grupo da origem e chegam ao grupo do destino.

O corte mínimo é aquele que apresenta a menor capacidade entre todas as divisões possíveis. Ele representa um limite para a quantidade máxima de fluxo que pode passar pela rede.

## 8. Teorema do Fluxo Máximo e Corte Mínimo

O teorema do fluxo máximo e corte mínimo estabelece que o maior fluxo possível entre a origem e o destino é igual à capacidade do corte mínimo da rede.

Na prática, isso significa que existe um limite para a quantidade de fluxo que pode ser transportada, determinado pelas capacidades das arestas que separam a origem do destino.

Esse teorema também permite identificar quando uma solução chegou ao máximo. Quando não existem mais caminhos aumentantes no grafo residual, o fluxo encontrado é máximo e sua quantidade corresponde à capacidade de um corte mínimo.

## 9. Algoritmo de Ford-Fulkerson

O algoritmo de Ford-Fulkerson é utilizado para encontrar o fluxo máximo em uma rede. Seu funcionamento é baseado na busca por caminhos aumentantes no grafo residual.

Primeiro, o algoritmo procura um caminho entre a origem e o destino. Quando encontra esse caminho, identifica seu gargalo e acrescenta essa quantidade ao fluxo. Em seguida, atualiza o grafo residual para considerar as novas capacidades disponíveis.

Esse procedimento é repetido enquanto existirem caminhos aumentantes. Quando nenhum outro caminho pode ser encontrado, o algoritmo encerra sua execução e o fluxo obtido é considerado máximo.

### Complexidade

Na implementação com busca em profundidade (DFS) e capacidades inteiras, a complexidade do Ford-Fulkerson é O(E × F), em que:

- E representa a quantidade de arestas do grafo.
- F representa o valor do fluxo máximo.

Essa complexidade depende do valor do fluxo máximo, e não apenas da quantidade de vértices e arestas. Por isso, quando as capacidades são muito grandes, o algoritmo pode precisar de muitas iterações.

Vale destacar que essa garantia de complexidade pressupõe capacidades inteiras. Com capacidades irracionais, determinadas escolhas de caminhos podem fazer com que o algoritmo não termine.

## 10. Algoritmo de Edmonds-Karp

Edmonds-Karp é uma versão do algoritmo de Ford-Fulkerson que utiliza a busca em largura (BFS) para encontrar os caminhos aumentantes.

Diferentemente de uma busca em profundidade, a busca em largura procura primeiro os caminhos com a menor quantidade de arestas entre a origem e o destino, considerando o grafo residual.

Essa escolha torna o funcionamento do algoritmo mais organizado e evita que ele dependa de escolhas arbitrárias de caminhos. Além disso, garante uma complexidade de O(V × E²), em que V representa a quantidade de vértices e E a quantidade de arestas.

Por esse motivo, Edmonds-Karp é mencionado como uma alternativa ao Ford-Fulkerson, pois apresenta uma garantia de tempo polinomial, independentemente dos valores das capacidades.

## 11. Considerações Finais

Os conceitos apresentados ajudam a compreender como funciona o problema do fluxo máximo em grafos e quais elementos são necessários para encontrar uma solução.

O algoritmo de Ford-Fulkerson utiliza o grafo residual, os caminhos aumentantes e os gargalos para aumentar o fluxo até atingir seu limite máximo. Já o Edmonds-Karp utiliza a busca em largura para escolher os caminhos de maneira mais organizada e garantir uma complexidade polinomial.

Dessa forma, conhecer esses conceitos é importante para entender tanto a teoria quanto a implementação dos algoritmos de fluxo máximo.