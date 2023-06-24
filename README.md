# lab-concorrente

## Libs usada para concorrencia
Como cada busca de ator é independente das outras, podemos executar diversas tarefas em paralelo para melhor eficiencia sem muita preocupação com os possiveis problemas de concorrencia.

### ExecutorService e Executors
Essa lib nos permite criar, gerenciar, matar nossas threads de forma simples. Sem ela não seria possivel ter concorrencia.

### concurrent.Future
O future nos permite saber quando uma thread terminou sua tarefa, o que dá a possibilidade de pegarmos os resultados com garantia de que vai ser válido. Sem Future, perderíamos a capacidade de rastrear o progresso e o resultado das tarefas assíncronas, o que poderia resultar em termos informações incompletas ou nulas.

### concurrent.Callable
O Callable é usado para criar tarefas que retornam um resultado e que podem lançar uma exceção. É parecido com o Runnable, mas o runnable não pode retornar um resultado.


## Estrategia usada
A grande vantagem da concorrencia nesse caso, é que podemos realizar outras tarefas enquanto esperamos o tempo de resposta do servidor, diferente da sequencial, que tem que esperar toda vez.

O código cria um pool de threads com um número fixo de threads, o número máximo de tarefas que podem ser executadas simultaneamente.
Para cada ID de ator na lista de IDs de atores, o código cria uma tarefa Callable que busca o ator correspondente pra calcular sua classificação.

O código possui uma lista de Futures, e depois pode iterar sobre a lista para calcular os resultados

## Resultados
É possivel perceber uma difença esmagadora nas versões: <br>
### 1000 atores: <br>
#### Sequencial: <br>
Em media a sequencial demorou 90 segundos para fazer as operações
#### Concorrente (10 threads): <br>
Em média teve 11 segundos de resposta, uma diferença absurda <br>
### 10000 atores: <br>
#### Sequencial: <br>
Em media a sequencial demorou 847 segundos para fazer as operações <br>
#### Concorrente (10 threads): <br>
Em média teve 90 segundos de resposta, mais uma vez sendo uma diferença abismal. A mesma velocidade que a sequencial precisou para fazer 1/10 de atores. <br>
### Conclusão <br>
Podemos ver que existe uma relação direta e linear entre a quantidade de threads e a velocidade de resposta, o tempo da reposta praticamente é dividido pela quantidade de threads.
