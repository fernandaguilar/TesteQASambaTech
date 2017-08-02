# Language: pt-br

# Data: 01/08/2017

# Autor: Fernanda Aguilar

# Projeto: Teste QA SambaTech
# Story: 1

Funcionalidade: Efetuar Login


Como gerente do sistema Samba Vídeos 
Eu quero que meus 
clientes possam logar corretamente no sistema
De modo que eles consigam ter acesso a todas as funcionalidades do sistema.

Cenário: Fluxo de usuário efetuando login no sistema com sucesso

Dado um usuário com permissão
QUANDO o mesmo preenche os campos <Email> e <Senha>
E o mesmo clica no botão [Entrar] 
ENTAO o sistema redireciona para a página principal


Cenário: Fluxo de usuário efetuando login no sistema com credenciais inválidas


Dado um usuário com permissão
QUANDO o mesmo preenche os campos <Email> e <Senha> com credenciais inválidas
E o mesmo clica no botão [Entrar] 
ENTAO o sistema exibe a mensagem indicando erro na autenticação
E não consegue efetuar login.



