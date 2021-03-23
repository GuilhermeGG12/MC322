# Lab 01

## Exercício do Empréstimo

Em um financiamento com juros compostos e número de parcelas fixas parte-se dos seguintes parâmetros:
* `S` - valor da primeira parcela
* `N` - número de parcelas
* `J` - percentual de juros mensal

A primeira parcela a ser paga do financiamento é sempre igual a `S`. A partir daí é feita uma atualização mensal da parcela, em que cada nova parcela é calculada a partir da parcela do mês anterior, conforme a fórmula:

> #### Parcela<sub>mês</sub> = Parcela<sub>mês-1</sub> * (1 + `J` / 100)

O financiamento encerra quando as `N` parcelas são pagas.
