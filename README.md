# API de Produtos para ecommerce

Esta API permite a criação, leitura, atualização e exclusão de produtos. A rota principal é `/product`, com métodos para listar, adicionar, buscar por ID, atualizar e excluir produtos.

### Estrutura do Payload

```json
{
  "name": "nome do produto",
  "description": "descrição do produto",
  "price": 200,
  "quantity": 10
}
```

---

## Endpoints

### 1. **Criar Produto**

- **Método:** `POST`
- **Rota:** `/product`
- **Descrição:** Cria um novo produto.
- **Request Body:**
  ```json
  {
    "name": "nome do produto",
    "description": "descrição do produto",
    "price": 200,
    "quantity": 10
  }
  ```
- **Response:**
  - **Status:** `201 Created`
  - **Body:** Retorna os detalhes do produto criado com o ID gerado.
  ```json
  {
    "id": 1,
    "name": "nome do produto",
    "description": "descrição do produto",
    "price": 200,
    "quantity": 10
  }
  ```

---

### 2. **Listar Todos os Produtos**

- **Método:** `GET`
- **Rota:** `/product`
- **Descrição:** Retorna uma lista de todos os produtos cadastrados.
- **Response:**
  - **Status:** `200 OK`
  - **Body:** Uma lista de produtos.
  ```json
  [
    {
      "id": 1,
      "name": "nome do produto",
      "description": "descrição do produto",
      "price": 200,
      "quantity": 10
    },
    {
      "id": 2,
      "name": "outro produto",
      "description": "outra descrição",
      "price": 150,
      "quantity": 5
    }
  ]
  ```

---

### 3. **Buscar Produto por ID**

- **Método:** `GET`
- **Rota:** `/product/{id}`
- **Descrição:** Retorna os detalhes de um produto específico, identificado pelo seu ID.
- **Parâmetros de Rota:**
  - `id` (obrigatório): O ID do produto a ser buscado.
- **Response:**
  - **Status:** `200 OK`
  - **Body:** Detalhes do produto.
  ```json
  {
    "id": 1,
    "name": "nome do produto",
    "description": "descrição do produto",
    "price": 200,
    "quantity": 10
  }
  ```
  - **Erro:**
    - **Status:** `404 Not Found`
    - **Body:** Produto não encontrado.

---

### 4. **Atualizar Produto**

- **Método:** `PUT`
- **Rota:** `/product/{id}`
- **Descrição:** Atualiza os detalhes de um produto específico.
- **Parâmetros de Rota:**
  - `id` (obrigatório): O ID do produto a ser atualizado.
- **Request Body:**
  ```json
  {
    "name": "nome atualizado",
    "description": "descrição atualizada",
    "price": 250,
    "quantity": 15
  }
  ```
- **Response:**
  - **Status:** `200 OK`
  - **Body:** Detalhes do produto atualizado.
  ```json
  {
    "id": 1,
    "name": "nome atualizado",
    "description": "descrição atualizada",
    "price": 250,
    "quantity": 15
  }
  ```
  - **Erro:**
    - **Status:** `404 Not Found`
    - **Body:** Produto não encontrado.

---

### 5. **Excluir Produto**

- **Método:** `DELETE`
- **Rota:** `/product/{id}`
- **Descrição:** Exclui um produto específico identificado pelo seu ID.
- **Parâmetros de Rota:**
  - `id` (obrigatório): O ID do produto a ser excluído.
- **Response:**
  - **Status:** `200 OK`
  - **Body:** Detalhes do produto atualizado.
  ```json
  {
    "id": 1,
    "name": "nome",
    "description": "descrição",
    "price": 250,
    "quantity": 15
  }
  ```
  - **Erro:**
    - **Status:** `404 Not Found`
    - **Body:** Produto não encontrado.

---

### Códigos de Status Comuns

- **200 OK:** Requisição bem-sucedida.
- **201 Created:** Produto criado com sucesso.
- **204 No Content:** Produto excluído com sucesso.
- **400 Bad Request:** Erro de validação ou dados inválidos.
- **404 Not Found:** Produto não encontrado.

---


Essa documentação cobre todos os métodos CRUD para a API de produtos.
