# Chapa Metálica

Uma chapa metálica tem seus quatro lados mantidos a temperaturas constantes, podendo ser diferentes ou não. A temperatura no interior da chapa, inicialmente valendo 0°C, tem seu valor modificado de acordo com a vizinhança de cada ponto. Suponha que, a cada etapa/round, a temperatura de um ponto interno seja a média dos seus quatro vizinhos (os dois da vertical – acima e abaixo - e os dois da horizontal – à esquerda e à direita). Nesse problema, todos os pontos serão atualizados ao mesmo tempo, não utilizando as novas temperaturas dos pontos internos enquanto todos não tiverem sido calculados. Os pontos dessa chapa podem ser representados em uma grade com linhas e colunas.

A respeito do contexto acima, faça programa(s) em Java para responder às seguintes questões (obs1.: construa métodos auxiliares que julgar necessários, importantes ou úteis. Obs2.: utilize os tipos primitivos para exercitar a lógica de programação):

1) Considere que a temperatura inicial seja dada da seguinte forma:
a) Primeira coluna: 100°C
b) Última coluna: -3°C
c) Primeira linha: 20°C
d) Última linha: 20°C

Para uma chapa com 6 colunas e 5 linhas, após quantas iterações a chapa entrará em equilíbrio térmico (isto é, as temperaturas de todos os pontos serão constantes)? Considere as temperaturas com duas casas decimais. (obs.: as temperaturas das quinas ou vértices não serão relevantes, e podem assumir o valor dado inicialmente nas linhas).

2) Faça uma versão do programa anterior que, dados um número máximo de iteração e um erro máximo aceitável (), itere até um desses dois casos acontecer. Compare o resultado com o exercício 1).

3) Faça uma versão dos programas anteriores que permita ao usuário:
a) Digitar as dimensões da chapa (linhas e colunas)
b) Digitar os valores das temperaturas dos lados
c) Digitar o número máximo de iterações
d) Digitar o erro máximo aceitável
e) Digitar o número de casas decimais que serão mostrados os resultados

Feito isso, utilizando os dados do exercício 1, após quantas iterações a chapa apresentará um erro máximo aceitável abaixo de 1e-7?
