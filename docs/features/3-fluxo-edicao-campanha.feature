# Language: pt-br

# Data: 01/08/2017

# Autor: Fernanda Aguilar

# Projeto: Teste QA SambaTech
# Story: 3

Funcionalidade: Fluxo de Edi��o 


Como gerente do sistema Samba V�deos 
Eu quero que meus 
clientes possam editar e manter campanhas
De modo que eles consigam editar dados das campanhas, ativas, inativas, processando, destacadas e em erro.

Cen�rio: Fluxo de Edi��o de Campanha inv�lida

Dado que eu estou na p�gina de edi��o de campanha
E est�o dispon�veis os campos j� preenchidos
Quando eu edito as informa��es do campos de forma inv�lida
E clico no bot�o [Editar campanha]

Ent�o o sistema informa que n�o � poss�vel editar a campanha.


Cen�rio: Fluxo de Edi��o de Campanha v�lida

Dado que eu estou na p�gina de edi��o de campanha
E est�o dispon�veis os campos j� preenchidos
Quando eu edito as informa��es do campos de forma v�lida
E clico no bot�o [Editar campanha]

Ent�o o sistema informa que a campanha foi criada com sucesso.