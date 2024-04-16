# Mercadinho

<p align="center">Projeto responsável pelo CRUD de produtos de um mercado.</p>


### Features

<p>Existem 3 setores: ALimento, Bebidas e Produtos de Limpeza. Cada um com uma classe responsável pelo CRUD</p>

### Cadastro de produtos 
<p> Recebe as informações sobre o novo produto, verificando se o ele já existe, caso nao exista, cria um novo registro de um produto no banco de dados. Retorna uma resposta de sucesso. Se for invalido: Retorna uma reposta informando que os dados precisam ser válidos.
</p>

### Listar produtos
<p>
Consulta o banco de dados para obter os detalhes dos produtos e retorna a lista de produtos cadastrados. Se não existir registro: Retorne uma resposta indicando que não foi encontrado.
</p>

### Listar produtos por código
<p>
  Recebe uma solicitação para ler informações de um produto por código. Se o produto existir: Retorna as informações do produto. Se o produto não existir: Retorna uma resposta indicando que o produto não foi encontrado.
</p>

### Deletar produto
<p>
  Verifica se o produto existe no banco de dados. Se existir: é excluído no banco de dados. Se o produto não existir: Retorna uma resposta indicando que o produto não foi encontrado.
</p>

### Atualizar 
*Em construção

<hr>

### 🛠 Tecnologias
Java 11 - MySQL - JDBC

### Pré-requisitos e Testes
Necessário instalação e configuração de um banco de dados MySQL. Database criada com o nome "mercado".
Os testes podem ser realizados no terminal da IDE. 
