# Language: pt-br

# Data: 01/08/2017

# Autor: Fernanda Aguilar

# Projeto: Teste QA SambaTech
# Story: 2Funcionalidade: Fluxo de Cadastro


Como gerente do sistema Samba Vídeos 
Eu quero que meus 
clientes possam cadastrar e manter campanhas
De modo que eles consigam ver campanhas, ativas, inativas, processando, destacadas e em erro.

Cenário: Fluxo de Cadastro informando os campos não obrigatórios

Dado que eu estou na página de cadastro de campanha
E estão disponíveis os campos obrigatórios para preenchimento
E campos não obrigatórios
Quando eu informo apenas os campos não obrigatórios
E clico no botão [Criar campanha]

Então o sistema informa que não é possível criar a campanha exibindo a mensagem:

"Ocorreram erros ao criar esta campanha:
Selecione um anúncio para esta campanha.
Adicione categorias ou gêneros à segmentação da campanha.
Informe a data para iniciar a campanha.
Informe a data para finalizar a campanha.
Informe o custo da campanha.
Informe a meta para a campanha.
Informe uma URL de destino válida para o clique no anúncio."

Cenário: Fluxo de Cadastro informando os campos obrigatórios

Dado que eu estou na página de cadastro de campanha
E estão disponíveis os campos obrigatórios para preenchimento
E campos não obrigatórios
Quando eu informo apenas os campos obrigatórios
E clico no botão [Criar campanha]

Então o sistema informa que a campanha foi criada com sucesso.