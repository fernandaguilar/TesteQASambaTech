# Language: pt-br

# Data: 01/08/2017

# Autor: Fernanda Aguilar

# Projeto: Teste QA SambaTech
# Story: 2Funcionalidade: Fluxo de Cadastro


Como gerente do sistema Samba V�deos 
Eu quero que meus 
clientes possam cadastrar e manter campanhas
De modo que eles consigam ver campanhas, ativas, inativas, processando, destacadas e em erro.

Cen�rio: Fluxo de Cadastro informando os campos n�o obrigat�rios

Dado que eu estou na p�gina de cadastro de campanha
E est�o dispon�veis os campos obrigat�rios para preenchimento
E campos n�o obrigat�rios
Quando eu informo apenas os campos n�o obrigat�rios
E clico no bot�o [Criar campanha]

Ent�o o sistema informa que n�o � poss�vel criar a campanha exibindo a mensagem:

"Ocorreram erros ao criar esta campanha:
Selecione um an�ncio para esta campanha.
Adicione categorias ou g�neros � segmenta��o da campanha.
Informe a data para iniciar a campanha.
Informe a data para finalizar a campanha.
Informe o custo da campanha.
Informe a meta para a campanha.
Informe uma URL de destino v�lida para o clique no an�ncio."

Cen�rio: Fluxo de Cadastro informando os campos obrigat�rios

Dado que eu estou na p�gina de cadastro de campanha
E est�o dispon�veis os campos obrigat�rios para preenchimento
E campos n�o obrigat�rios
Quando eu informo apenas os campos obrigat�rios
E clico no bot�o [Criar campanha]

Ent�o o sistema informa que a campanha foi criada com sucesso.