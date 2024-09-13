# ufabc-compiler
Projeto da disciplina de compiladores da Universidade Federal do ABC.

## Compilador
O Projeto tem como base o curso de compiladores do Professor Isidro[^1] e utiliza a gramatica *Grammar.g4* para gerar um analisador lexico e um parser utilizando a ferramenta ANTLR.
Possui as seguintes funcionalidades:
- Declarar variáveis de 2 tipos (Double e String)
- Expressões aritméticas utilizando `+` `-` `*` `/`
- Estrutura IF e ELSE
- Estrutura WHILE e DO WHILE
- Atribuicao de variaveis
- Numeros inteiros e decimais
- Entrada e Saida de dados

## Checklist
| Item Obrigatorio | Definicao| Implementados
| ------------- | ------------- | ------------- |
| 1  | Possui 2 tipos de variáveis  | :white_check_mark: |	
| 2  | Possui a estrutura If.. else  | :white_check_mark:|
| 3  | Possui estrutura de controle while/do while  | :white_check_mark:|
| 4  | Operações Aritméticas executadas corretamente  | :white_check_mark:|
| 5  | Atribuições realizadas corretamente  | :white_check_mark:|
| 6  | Possui operações de Entrada e Saída  | :white_check_mark:|
| 7  | Aceita números decimais  | :white_check_mark:|
| 8  | Verificar se a variável já foi previamente declarada  | :white_check_mark:|
| 9  | Verificar se a variável foi declarada e não foi usada  | :white_check_mark:|
| 10  | Verificar se uma variável está sendo usada sem ter valor inicial  | :white_check_mark:|

## Opcionais
- Geração de várias linguagens-alvo
- Uma API Rest para implementação do compilador

## Run
> [!TIP]
> Comando para compilar utilizando o ANTLR:
>```
>java -cp antlr-4.13.2-complete.jar org.antlr.v4.Tool Grammar.g4 -o src/io/compiler/core -package io.compiler.core
>```

> [!TIP]
> Comando para executar o compilador:
>```
>java -cp target/ufabc-compiler-1.0-SNAPSHOT.jar:antlr-4.13.2-complete.jar src/main/java/io/compiler/main/MainClass.java arquivo
>```

[^1]:https://youtube.com/playlist?list=PLjcmNukBom6--0we1zrpoUE2GuRD-Me6W&si=RJLZ6JC0Wmu0usvJ
