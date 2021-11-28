# Forever-A1-TCESP-Java
Projeto avaliativo acadêmico em parceria com o Tribunal de Contas do Estado de São Paulo (TCESP). Página Web para recuperação de dados de despesas de municípios do estado.
Também é possível fazer uma organização dos municípios que já tiveram suas despesas checadas pelo TCESP ou que apresentam algum tipo erro ao apresentar esses dados em seus Portais da Transparência.

Uso de banco de dados MySQL, Hibernate, Spring Boot e outras dependências.

## DESCRIÇÃO DO PROJETO:
O estado de São Paulo possui muitos municípios, e por lei, todos eles devem disponibilizar dados referentes as suas despesas mensais em seus Portais da Transparência para que a população possa ter acesso à essas informações.

Um dos trabalhos do Tribunal de Contas do Estado de São Paulo (TCESP) é conferir cada um desses portais e verificar se essas dados de despesas estão sendo disponibilizados e se estão sendo apresentados de forma correta.
Este, porém, é um trabalho demorado que é dificuldade pelo fatos de essas informações estarem espalhadas em tantas páginas na web que, inclusive, possuem padrões de pesquisa diferentes.

O projeto Forever A1 veio com a ideia de ajudar nessa tarefa de resgatar todas as despesas e organizar os "status" dos municípios e o trabalho dos fiscais do TCESP.

Possibilitamos que as despesas sejam recuperadas de um lugar só, através de um página de pesquisa que faz acesso à uma API e nos devolve esses relatórios.
Também criamos uma tabela de checagem, onde é possível adicionar os diversos municípios do estado de São Paulo e manter um controle sobre quais já tiveram suas despesas e portais da transparência checados, quando foram checados, por qual fiscal foram checados e também se apresentam algum tipo de erro que precisa ser corrigido. 


## API:
A API utilizada pertence ao TCESP e pode ser encontrada no seguinte link: https://transparencia.tce.sp.gov.br/apis


## TELAS:


### Tela de Login
<img src="https://github.com/MarcosLopes99/Forever-A1-TCESP-Java/blob/master/git_images/login.png" width="750">


### Tela de Cadastro
<img src="https://github.com/MarcosLopes99/Forever-A1-TCESP-Java/blob/master/git_images/cadastro.png" width="750">


### Tela de Início
<img src="https://github.com/MarcosLopes99/Forever-A1-TCESP-Java/blob/master/git_images/inicio.png" width="750">


### Tela de Pesquisa de Despesas
<img src="https://github.com/MarcosLopes99/Forever-A1-TCESP-Java/blob/master/git_images/pesquisa.png" width="750">


### Tela de Resultado 1
<img src="https://github.com/MarcosLopes99/Forever-A1-TCESP-Java/blob/master/git_images/resultado_1.png" width="750">


### Tela de Resultado 2
<img src="https://github.com/MarcosLopes99/Forever-A1-TCESP-Java/blob/master/git_images/resultado_2.png" width="750">


### Tela da Tabela de Checagem
<img src="https://github.com/MarcosLopes99/Forever-A1-TCESP-Java/blob/master/git_images/checagem.png" width="750">

### Tela de Alteração de Status de Município
<img src="https://github.com/MarcosLopes99/Forever-A1-TCESP-Java/blob/master/git_images/alterar_status.png" width="750">
