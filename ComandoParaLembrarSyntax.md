## DDL (Data Definition Language):
```
CREATE TABLE Clientes (
    ClienteID INT PRIMARY KEY IDENTITY,
    Nome NVARCHAR(100),
    Email NVARCHAR(100)
);
CREATE TABLE Pedidos (
    PedidoID INT PRIMARY KEY IDENTITY,
    ClienteID INT FOREIGN KEY REFERENCES Clientes(ClienteID),
    DataPedido DATE,
    ValorTotal DECIMAL(10, 2)
);
CREATE TABLE Produtos (
    ProdutoID INT PRIMARY KEY IDENTITY,
    Nome NVARCHAR(100),
    Preco DECIMAL(10, 2)
);
CREATE TABLE DetalhesPedido (
    DetalheID INT PRIMARY KEY IDENTITY,
    PedidoID INT FOREIGN KEY REFERENCES Pedidos(PedidoID),
    ProdutoID INT FOREIGN KEY REFERENCES Produtos(ProdutoID),
    Quantidade INT,
    PrecoUnitario DECIMAL(10, 2)
);
CREATE TABLE Funcionarios (
    FuncionarioID INT PRIMARY KEY IDENTITY,
    Nome NVARCHAR(100),
    Cargo NVARCHAR(100)
);
CREATE TABLE Vendas (
    VendaID INT PRIMARY KEY IDENTITY,
    FuncionarioID INT FOREIGN KEY REFERENCES Funcionarios(FuncionarioID),
    ProdutoID INT FOREIGN KEY REFERENCES Produtos(ProdutoID),
    DataVenda DATE,
    Quantidade INT,
    ValorTotal DECIMAL(10, 2)
);
CREATE TABLE Categorias (
    CategoriaID INT PRIMARY KEY IDENTITY,
    Nome NVARCHAR(100),
    Descricao NVARCHAR(255)
);
CREATE TABLE Produtos (
    ProdutoID INT PRIMARY KEY IDENTITY,
    Nome NVARCHAR(100),
    Preco DECIMAL(10, 2),
    CategoriaID INT FOREIGN KEY REFERENCES Categorias(CategoriaID)
);
CREATE TABLE Enderecos (
    EnderecoID INT PRIMARY KEY IDENTITY,
    Rua NVARCHAR(100),
    Cidade NVARCHAR(100),
    CEP NVARCHAR(20)
);
CREATE TABLE Clientes (
    ClienteID INT PRIMARY KEY IDENTITY,
    Nome NVARCHAR(100),
    Email NVARCHAR(100),
    EnderecoID INT FOREIGN KEY REFERENCES Enderecos(EnderecoID)
);

```
## DML (Data Manipulation Language):
```
INSERT INTO Clientes (Nome, Email, EnderecoID)
VALUES ('João Silva', 'joao@example.com', 1),
       ('Maria Santos', 'maria@example.com', 2),
       ('Pedro Oliveira', 'pedro@example.com', 3);

INSERT INTO Pedidos (ClienteID, DataPedido, ValorTotal)
VALUES (1, '2024-02-29', 150.00),
       (2, '2024-02-28', 200.00),
       (3, '2024-02-27', 100.00);
INSERT INTO Produtos (Nome, Preco, CategoriaID)
VALUES ('Smartphone', 899.99, 1),
       ('Notebook', 1499.99, 1),
       ('Fone de Ouvido', 99.99, 2);

INSERT INTO DetalhesPedido (PedidoID, ProdutoID, Quantidade, PrecoUnitario)
VALUES (1, 1, 1, 899.99),
       (2, 2, 1, 1499.99),
       (3, 3, 2, 99.99);

INSERT INTO Funcionarios (Nome, Cargo)
VALUES ('Ana Souza', 'Vendedor'),
       ('Carlos Oliveira', 'Gerente');

INSERT INTO Vendas (FuncionarioID, ProdutoID, DataVenda, Quantidade, ValorTotal)
VALUES (1, 1, '2024-02-29', 1, 899.99),
       (2, 2, '2024-02-28', 1, 1499.99),
       (1, 3, '2024-02-27', 2, 199.98);

INSERT INTO Categorias (Nome, Descricao)
VALUES ('Eletrônicos', 'Produtos eletrônicos em geral'),
       ('Acessórios', 'Acessórios para dispositivos eletrônicos');

INSERT INTO Enderecos (Rua, Cidade, CEP)
VALUES ('Rua A', 'São Paulo', '01000-000'),
       ('Rua B', 'Rio de Janeiro', '20000-000'),
       ('Rua C', 'Belo Horizonte', '30000-000');


```
## DQL (Data Query Language):

```
SELECT * FROM Clientes;

SELECT Pedidos.PedidoID, Pedidos.DataPedido, Pedidos.ValorTotal, Clientes.Nome AS NomeCliente, Clientes.Email
FROM Pedidos
INNER JOIN Clientes ON Pedidos.ClienteID = Clientes.ClienteID;

SELECT Produtos.Nome AS NomeProduto, Produtos.Preco, Categorias.Nome AS NomeCategoria, Categorias.Descricao AS DescricaoCategoria
FROM Produtos
INNER JOIN Categorias ON Produtos.CategoriaID = Categorias.CategoriaID
WHERE Categorias.Nome = 'Eletrônicos';

SELECT DetalhesPedido.Quantidade, DetalhesPedido.PrecoUnitario, Produtos.Nome AS NomeProduto
FROM DetalhesPedido
INNER JOIN Produtos ON DetalhesPedido.ProdutoID = Produtos.ProdutoID
WHERE DetalhesPedido.PedidoID = 123;

SELECT Funcionarios.Nome AS NomeFuncionario, Funcionarios.Cargo, Vendas.DataVenda, Vendas.Quantidade, Vendas.ValorTotal
FROM Funcionarios
INNER JOIN Vendas ON Funcionarios.FuncionarioID = Vendas.FuncionarioID;

SELECT * FROM Produtos WHERE Preco > 100;

SELECT * FROM Clientes WHERE Cidade = 'São Paulo';

SELECT Enderecos.*, Clientes.Nome AS NomeCliente
FROM Enderecos
INNER JOIN Clientes ON Enderecos.EnderecoID = Clientes.EnderecoID;

```
