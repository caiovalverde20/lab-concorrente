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
