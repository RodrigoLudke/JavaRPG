# JavaRPG 

## OBJETIVO
- O objetivo desta atividade é integrar os conhecimentos avançados de programação e orientação a objetos. É uma atividade que requer dedicação e estudo, mas certamente é um desafio que irá incrementar suas habilidades de programador!
## DESCRIÇÃO GERAL
- Nos anos 90 a editora Marques Saraiva lançou uma série de livros-jogos chamada Aventuras Fantásticas, uma tradução dos livros da série Fighting Fantasy. Atualmente alguns títulos estão sendo relançados pela Editora Jambô. Basicamente os leitores criavam um personagem usando um sistema de regras bem simplificado e executava a leitura de trechos de textos que indicavam quais os próximos trechos deveriam ser lidos conforme as escolhas dos jogadores. Algumas vezes, algum trecho descrevia que o personagem havia encontrado algum item que deveria ser anotado em seu inventário ou descrevia um encontro com alguma criatura. Caso fosse bem sucedido no combate deveria ir até determinado trecho.

## TELAS
>O jogo possui quatro telas descritas abaixo:

- a) Tela de abertura: Esta tela apresenta as seguintes opções novo jogo, carregar jogo, exibir créditos e encerrar a aplicação. Em novo jogo cria uma nova partida e carregar jogo carrega uma partida salva anteriormente. Veja seção Salvar/Carregar. Em exibir créditos deve apresentar os nomes dos programadores;

- b) Tela de inventário do jogo: essa tela é onde devem ser feitas as “configurações” iniciais do personagem, ou seja, HABILIDADE, ENERGIA e SORTE. A mesma pode ser acionada sempre que o jogador quiser ter acesso ao inventário do personagem.

- c) Tela padrão do jogo: Nessa tela é apresentado o texto da aventura e são disponibilizadas as possibilidades de decisão do jogador.

- d) Tela de batalha: Tela em que deve ser apresentado o inimigo bem como sua Energia. Também é nessa tela que o jogador pode escolher qual opção irá usar: Atacar, Usar Magia (dependendo de quais magias tem em seu inventario, ou se algum item no inventário o permite usar alguma) ou Fugir;

## CRIAÇÃO DE PERSONAGEM
>Os desenvolvedores decidem como o jogador poderá atribuir os pontos de HABILIDADE, ENERGIA e SORTE. O jogador terá 12 pontos disponíveis para distribuir entre os atributos.

- A HABILIDADE terá o valor mínimo igual a 6 e valor máximo igual a 12;
- A ENERGIA terá o valor mínimo igual a 12 e valor máximo igual a 24;
- A SORTE terá o valor mínimo igual a 6 e valor máximo igual a 12;

## USO DA SORTE
- Nos combates ou em certas situações de jogo o jogador pode optar ou ser solicitado a Testar Sorte. É sorteado um valor aleatório e comparado com valor da sorte do personagem. Esse resultado define se ouve falha ou sucesso no teste. Quando usar sorte em combate o usuário pode ampliar o dano causado ao inimigo
ou reduzir o dano causado pelo inimigo no personagem. Cada vez que a sorte for usada deve ser decrementado em um o valor atual de SORTE.

## RESUMO DO CONTROLE DOS ATRIBUTOS DO PERSONAGEM/INVENTÁRIO
- **Habilidade:** Representa a destreza em combate. O valor influência diretamente nos resultados dos
combates.
- **Energia:** Representa sua constituição, ou seja, pontos de vida.
- **Sorte:** Como descrito sua sorte pode ser testada em determinados eventos e também pode mudar
valores do dano recebido ou causado. 
- **Magias:** Se o personagem for mago terá um numero de magias no inicio do jogo e no decorrer do
mesmo deve/pode adquirir outras, que influenciaram direto nos seus combates. Já personagens não magos
podem utilizar algumas magias desde que de posse de algum item magico.
- **Equipamentos:** No inicio do jogo o personagem deve possuir alguns itens básicos, além desses o
programador pode definir onde e quando o personagem pode adquirir novos itens, que vão para inventário do
mesmo. Quando quiser o jogador pode acessar a tela de inventário e modificar o que o personagem está
equipado.
- **Tesouro:** Materiais valiosos que o personagem adquire no decorrer da aventura.
- **Provisões:** Alimentos que permitem ao personagem recuperar Energia. Só podem ser usadas fora de
combate. Uma provisão recupera sempre 4 pontos de vida.

## FLUXO DO JOGO:
>Na tela inicial o Jogador pode tomar duas atitudes:
- Começar um novo jogo:
  - Deve ser carregada a tela do Inventario onde serão definidos os valores de HABILIDADE, ENERGIA E SORTE
  - Ainda na tela inventario pode ser visto com o que o personagem está equipado, que equipamentos extras possui e o quais tesouros/magias possui.
  - Depois de verificado o inventário o jogador passa para tela de jogo onde é apresentada o historia do jogo (tela padrão do jogo);
- Carregar Jogo:
  - Deve ser buscado em um arquivo as informações do inventário, do personagem e do progresso do jogo;
  - Apresentar o inventário para o Jogador;
  - Ir para tela de narrativa no ponto onde o Jogador salvou seu jogo (tela padrão do jogo).

>Na tela padrão do jogo:
- É apresentado o texto principal da cena e as possibilidades de decisão para o jogador.
- Cada cena deve ser armazenada em um arquivo separado. Vide seção Formato do Arquivo de Cena.

Existe ainda uma tela extra que pode ser chamada tela de combate, batalha ou encontros do
personagem. As decisões do personagem podem colocá-lo em perigo ou levá-lo a enfrentar inimigos, nessa
tela estarão as definições do inimigo como características e pontos de vida. Nesta tela estão disponíveis as
ações padrões de fugir, atacar, usar item e usar magia (se a história tem magia). Quando um monstro é
derrotado verifica-se se este possui provisões, itens e/ou tesouros. Caso possua, transfere-se estes elementos
para o inventário do personagem.
>O combate é feito da seguinte forma:
- 1. É gerado um número aleatório de 1 à 10 e somado a habilidade do monstro;
- 2. A mesma coisa é feita para o personagem;

Isso define a Força de Ataque (FA) dos combatentes. Quem tiver o maior FA é o vencedor e tira 2 pontos de energia do oponente. Se der empate ninguém acertou

Com o jogo iniciado/reiniciado o jogador deve ir seguindo a história do jogo e decidir quais as ações
tomar a partir de possibilidades disponibilizadas pelo programador. Essas decisões devem influenciar
diretamente o fluxo do jogo. Exemplos de decisões que podem ser tomadas são: i. que caminho seguir, ii.
tentar arrombar uma porta ou não iii. enfrentar ou fugir/esconder-se de um monstro etc.. O jogo deve conter
um fluxo de no mínimo 10 turnos (possibilidades de escolhas) para o Jogador sendo que essas decisões podem
possibilitar terminar a aventura mais rapidamente ou impedir/dificultar o jogador a finalizar a aventura.

## SALVAR/CARREGAR
- Sempre que uma nova cena é carregada o jogo é salvo automaticamente. Deve armazenar os dados do
personagem, o inventário completo, a cena atual e todas as cenas que já visualizou. Assim que a opção de
carregar um jogo salvo é efetuada deve ser feita a leitura do arquivo e restaurados os dados do personagem, o
inventário, as cenas que já foram visualizadas e posiciona o jogador na cena que foi salva a partida.

## FORMATO DOS ARQUIVOS DE CENA
- Cada cena é armazenada em um arquivo de texto. O nome de cada arquivo é um número sequencial –
1.txt, 2.txt, 3.txt. Cada arquivo está definido no seguinte formato:

>Cena 1

```
Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque faucibus, lorem a dignissim
tristique, lorem magna vulputate sem, et tincidunt lectus nulla ut velit. Ut tempor quam tincidunt odio
vehicula in mollis metus varius. Etiam dapibus, mi quis consequat ullamcorper, sem arcu aliquet tortor,
id semper nulla turpis et quam. Praesent vitae felis mi, aliquet fringilla sapien. Praesent molestie
vestibulum mattis. Integer a nisl lectus. Nulla ut urna lacus, vel fermentum metus. Aliquam eros quam,
fringilla id

I: chave;c;0;0;0

#2: Lorem ipsum dolor
#3: Praesent molestie
#4: Integer a nisl lectus
}
```
Estes números não são apresentados para o jogador são usados somente pelo programador como
localizador dos arquivos de cena. No exemplo acima é apresentada a cena 1 com três opções, conforme a
escolha são carregadas as cenas 2.txt, 3.txt ou 4.txt. No caso de I a cena oferece um item para o personagem.
Veja abaixo a descrição de um item.

- Quando a cena é um monstro o arquivo é formatado da seguinte maneira:

>Monstro
```
Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque faucibus, lorem a dignissim
tristique, lorem magna vulputate sem, et tincidunt lectus nulla ut velit. Ut tempor quam tincidunt odio
vehicula in mollis metus varius. Etiam dapibus, mi quis consequat ullamcorper, sem arcu aliquet tortor,
id semper nulla turpis et quam. Praesent vitae felis mi, aliquet fringilla sapien. Praesent molestie
vestibulum mattis. Integer a nisl lectus. Nulla ut urna lacus, vel fermentum metus. Aliquam eros quam,
fringilla id

N: Orc
M: S
H: 12
S: 10
E: 12
T: 1000
P: 1
I: chave;c;0;0;0
12;13
```
Onde,
- "Monstro" indica que a cena é um monstro
- N é o nome do monstro
- H é a habilidade
- S é a sorte
- E é a energia
- T é o tesouro, o número de moedas de ouro. Se T for omitido o monstro não provê tesouro
- P é a provisão, a quantidade de provisões. Se P for omitido o monstro não provê provisões
- I é um item. Se I for omitido o monstro não provê item
  - O elemento I é definido por 5 atributos:
    ```
    nome;tipo;combate;FA;dano
    ```
    Onde
    - nome é o nome do item, por exemplo, Espada larga;
    - tipo é o tipo de item. Pode ser: c para item comum, r para armadura e w para arma;
    - combate se pode ser usado em combate. Pode ser: 1 se pode ser usado em combate ou 0 se não pode
    - FA é o bônus positivo ou negativo da força de ataque. Se for uma armadura refere-se ao FA do oponente e se for uma arma FA refere-se ao atacante.
    - Dano é um bônus positivo ou negativo aplicado ao dano. Se for uma armadura é quanto de dano é reduzido do dano e se for uma arma refere-se quanto de dano aumenta-se o ataque contra o oponente.

- 12;13 o primeiro número é a próxima cena em caso de sucesso (monstro derrotado) e o segundo número a
próxima cena em caso de derrota (monstro não derrotado)

## REQUISITOS
- ➢  A temática das histórias é livre, exceto pornografia, racismo, qualquer tipo de discriminação
ou temas ilegais;
- ➢  Deve ser implementado em Java;
- ➢  Uma solução orientada a objetos e organizada modularmente em diversos arquivos;
- ➢  Se forem utilizar vetores, esses deverão ser alocados dinamicamente e de forma eficiente,
ou seja, que não consuma grande tempo de processamento.

##  BONUS – REQUISITOS ADICIONAIS
**Abaixo estão listados alguns requisitos adicionais que serão avaliados como bônus, ou seja, pode
incrementar a avaliação. Quem não implementar estes requisitos não irão sofrer nenhuma penalidade
quanto avaliação.**
- ➢ Dar a opção de salvar e carregar mais de uma partida;
- ➢ Implementar a funcionalidade de não permitir a fuga para certos monstros. O jogador tenta fugir,
mas não consegue;
- ➢ Implementar um sistema de magia que influencie os personagens, monstros e itens do jogo;
- ➢ Oferecer dois modos de criação de personagem. Além do modo de distribuição de pontos, oferecer
um modo aleatório;
- ➢ Só permitir ir para uma cena se o personagem possuir determinado item no inventário;
- ➢ Apresentar o jogo no modo gráfico. Pode ser usada qualquer biblioteca gráfica a escolha;
- ➢ Pode ser exibido no modo janela ou em full screen.

## CRITÉRIOS DE AVALIAÇÃO
**Deve ser funcional! Programa que não executa não é programa. Deve ser compilável e executável.
Aplicativos que não executarem serão desconsiderados e será atribuída nota zero para os aprendizes.**
- ➢ Projeto adequado orientado a objetos;
- ➢ Código estruturado, identado e comentado;
- ➢ Respeitar TODOS os requisitos descritos anteriormente.
- ➢ Fidelidade as regras do jogo e descrição da aplicação. É para ser implementado exatamente o que
está sendo pedido. Não tente simplificar o que está sendo solicitado.

## INSTRUÇÕES PARA ENTREGA
**A entrega será realizada SOMENTE via moodle, até ANTES do início da aula do dia 29/04, ou seja, a
tarefa irá fechar as 19h30min do dia 29/04. Se programem para entregar dentro do prazo. Trabalhos não
entregues no prazo não serão aceitos**



