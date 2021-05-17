# Projeto WordCounter - Estilo Hollywood

Esse projeto contém a implementação de um **contador de palavras** no estilo Hollywood, proposto pela professora Cristina Viera Lopes, em seu livro Exercises in
Programming Style.

## O estilo Hollywood

O estilo Hollywood se enquadra na categoria de objetos e interação entre objetos. Esta categoria contém estilos de programação que se aproveitam da abstração de 
objetos e de sua interação para implementação de programas.

Ele caracteriza-se pela inversão de controle em relação a chamadas de eventos, ao invés de uma entidade chamar outra entidade com o intuito de obter 
alguma informação, a primeira entidade registra na segunda um callback e então a segunda entidade o chama em um momento posterior. Este comportamento permite 
que um receptor acione várias ações em muitos acionadores em um momento determinado pelo receptor. Isso possibilita uma composição de módulos diferente,
pois muitos módulos podem registrar manipuladores para o mesmo evento.

## Implementação

A linguagem escolhida foi **Scala**, utilizando o compilador **SBT**.

Os eventos do programa são divididos em três etapas: carregamento, execução e finalização,
indicando início, execução e fim.

Na classe WordFrequencyFramework temos três listas que irão armazenar esses eventos
(loadEventHandler, doWorkEventHandler e endEventHandler), após preenchimento dessas listas será chamado o método run, o
qual irá executar os eventos das listas. Esta classe também provê métodos que irão registrar os
eventos, populando as listas. Assim, WordFrequencyFramework age como um orquestrador,
gerenciando quando os objetos da aplicação serão chamados e executados.

Na classe StopWordFilter, no seu construtor, ocorre um registro de um evento de carregamento, o
qual irá ler como entrada as palavras a serem ignoradas, além disso a classe tem o método
isStopWord para verificar se uma palavra é ou não uma palavra que deve ser ignorada.

Olhando agora para a classe DataStorage cria-se uma quarta lista para os eventos que irão atuar
sobre as palavras (word events), por isso, esta classe possui um método registerForWordEvent,
como explicado anteriormente, registra o evento na lista. O construtor registra dois eventos: um de
carregamento que irá ler a entrada de dados contida no arquivo txt e normalizá-lo e o outro de
execução, que irá separar os dados em palavras e para cada palavra não ignorada, chamará os
eventos registrado na lista de wordEvent.

Na classe WordFrequencyCounter possui um dicionário que armazena a frequência das
palavras. Em seu construtor há o registro de dois eventos: ele contém a referência do DataStorage,
conseguindo invocar o método registerForWordEvent, que irá registrar um evento de incremento da
frequência da palavra; e também registra o evento de finalização que exibirá no console a lista de
palavras e suas respectivas frequências.

Cada linguagem possui sua especificidade, dessa forma, como realizamos a implementação em
Scala, a solução encontrada foi utilizar traits e objetos, para cada tipo de evento existe um trait que
define a assinatura dos métodos, e um objeto que implementa os métodos definidos no seu
respectivo trait. Desde modo, as listas de eventos na verdade conterão objetos com métodos únicos
que serão executados e estes sim configuram o evento em si.

Este estilo é utilizado por vários frameworks orientados a objetos, pois é um mecanismo poderoso
para que o código do framework acione ações em um código de aplicação arbitrário. Inversão de
controle é justamente o que diferencia frameworks de bibliotecas. Contudo, o estilo Hollywood, se
não bem escrito, resulta em código extremamente difícil de entender.

## Execução

Para executar o programa, basta entrar no terminal do SBT dentro da pasta raíz do projeto.

```
cd <caminho>/HollywoodStyle
sbt
```

E então execute o comando run, passando como argumento o caminho do arquivo txt contendo um texto o qual deseja-se contar as palavras.

```
run ~/exemplo/texto.txt
```
