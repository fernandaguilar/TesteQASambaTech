# Language: pt-br

# Data: 01/08/2017

# Autor: Fernanda Aguilar

# Projeto: Teste QA SambaTech
# Story: 4

Funcionalidade: Fluxo de Exclus�o


Como gerente do sistema Samba V�deos 
Eu quero que meus 
clientes possam excluir suas campanhas
De modo que eles consigam apagar os dados e as campanhas

Cen�rio: Fluxo de N�o Exclus�o de Campanha 

Dado que eu estou na p�gina listagem de campanha
E est�o dispon�veis todas as campanhas criadas
Quando eu seleciono uma ou mais campanhas.
E clico no bot�o [Excluir campanha]
E o sistema exibe a popup com as informa��es

Cancelar | Sim, eu quero excluir

E clico no bot�o [Cancelar]

Ent�o o sistema informa cancela a a��o sem fazer nenhuma altera��o.


Cen�rio: Fluxo de Exclus�o de Campanha 

Dado que eu estou na p�gina listagem de campanha
E est�o dispon�veis todas as campanhas criadas
Quando eu seleciono uma ou mais campanhas.
E clico no bot�o [Excluir campanha]
E o sistema exibe a popup com as informa��es

Cancelar | Sim, eu quero excluir

E clico no bot�o [Sim, eu quero excluir]

Ent�o o sistema exclui a campanha e exibe a mensagem: "A campanha foi exclu�da com sucesso!"