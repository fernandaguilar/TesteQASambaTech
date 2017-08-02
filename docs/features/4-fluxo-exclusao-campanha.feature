# Language: pt-br

# Data: 01/08/2017

# Autor: Fernanda Aguilar

# Projeto: Teste QA SambaTech
# Story: 4

Funcionalidade: Fluxo de Exclusão


Como gerente do sistema Samba Vídeos 
Eu quero que meus 
clientes possam excluir suas campanhas
De modo que eles consigam apagar os dados e as campanhas

Cenário: Fluxo de Não Exclusão de Campanha 

Dado que eu estou na página listagem de campanha
E estão disponíveis todas as campanhas criadas
Quando eu seleciono uma ou mais campanhas.
E clico no botão [Excluir campanha]
E o sistema exibe a popup com as informações

Cancelar | Sim, eu quero excluir

E clico no botão [Cancelar]

Então o sistema informa cancela a ação sem fazer nenhuma alteração.


Cenário: Fluxo de Exclusão de Campanha 

Dado que eu estou na página listagem de campanha
E estão disponíveis todas as campanhas criadas
Quando eu seleciono uma ou mais campanhas.
E clico no botão [Excluir campanha]
E o sistema exibe a popup com as informações

Cancelar | Sim, eu quero excluir

E clico no botão [Sim, eu quero excluir]

Então o sistema exclui a campanha e exibe a mensagem: "A campanha foi excluída com sucesso!"