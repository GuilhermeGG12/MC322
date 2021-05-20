# Arquivos Java do Jogo

Para executar o jogo, execute o programa AppMundoWumpus passando como parâmetro o caminho de um arquivo CSV com as instruções iniciais da caverna. Após isso, o usuário deverá digitar um nome no terminal bem como, os possíveis comandos de ação abaixo:

* w -> Herói movimenta para a sala acima;
* s -> Herói movimenta para a sala abaixo;
* d -> Herói movimenta para a sala a direita;
* a -> Herói movimenta para a sala a esquerda;
* k -> Herói equipa a flecha;
* c -> Herói captura o ouro;
* q -> O usuário sai do jogo.

[Arquivos Java lab06](scr/mc322/lab06)

# Destaques de Arquitetura

## Encapsulamento

```Java
public class Caverna {
	private static int MAX_X;
	private static int MAX_Y;
	
	private Sala[][] salas;
```

O código acima destaca o encapsulamento no projeto. O fato de a matriz de salas ser privada implica que, nenhum objeto externo à classe Caverna poderá ter acesso à matriz. Assim, o encapsulamento do projeto não é violado.

## Arquitetura inicial flexível

```Java
public abstract class Componente {
	protected int[] coordenadas;
	protected char tipo;
	protected int numSecundarios;
	protected Componente secundarios[];
	protected Caverna caverna;
```

O código acima destaca a capacidade de expandir a arquitetura inicial do projeto. Por termos a classe Componente como abstrata, temos uma base genérica para a criação de outros tipos de componentes, já que a classe desses componentes seria responsável pelas especificidades na sua estrutura, assim, apenas teríamos que fazer pequenas modificações em outras classes para que os novos componentes fossem incluídos totalmente ao projeto.