# Language: pt-br

# Data: 01/08/2017

# Autor: Fernanda Aguilar

# Projeto: Teste QA SambaTech
# Story: 1

Funcionalidade: Efetuar Login


Como gerente do sistema Samba V�deos 
Eu quero que meus 
clientes possam logar corretamente no sistema
De modo que eles consigam ter acesso a todas as funcionalidades do sistema.

Cen�rio: Fluxo de usu�rio efetuando login no sistema com sucesso

Dado um usu�rio com permiss�o
QUANDO o mesmo preenche os campos <Email> e <Senha>
E o mesmo clica no bot�o [Entrar] 
ENTAO o sistema redireciona para a p�gina principal


Cen�rio: Fluxo de usu�rio efetuando login no sistema com credenciais inv�lidas


Dado um usu�rio com permiss�o
QUANDO o mesmo preenche os campos <Email> e <Senha> com credenciais inv�lidas
E o mesmo clica no bot�o [Entrar] 
ENTAO o sistema exibe a mensagem indicando erro na autentica��o
E n�o consegue efetuar login.



