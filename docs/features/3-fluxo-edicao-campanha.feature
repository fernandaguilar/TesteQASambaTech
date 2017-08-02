# Language: pt-br

# Data: 01/08/2017

# Autor: Fernanda Aguilar

# Projeto: Teste QA SambaTech
# Story: 3

Funcionalidade: Fluxo de Edição 


Como gerente do sistema Samba Vídeos 
Eu quero que meus 
clientes possam editar e manter campanhas
De modo que eles consigam editar dados das campanhas, ativas, inativas, processando, destacadas e em erro.

Cenário: Fluxo de Edição de Campanha inválida

Dado que eu estou na página de edição de campanha
E estão disponíveis os campos já preenchidos
Quando eu edito as informações do campos de forma inválida
E clico no botão [Editar campanha]

Então o sistema informa que não é possível editar a campanha.


Cenário: Fluxo de Edição de Campanha válida

Dado que eu estou na página de edição de campanha
E estão disponíveis os campos já preenchidos
Quando eu edito as informações do campos de forma válida
E clico no botão [Editar campanha]

Então o sistema informa que a campanha foi criada com sucesso.