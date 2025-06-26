# API de Produtos para ecommerce

Esta API permite a criação, leitura, atualização e exclusão de produtos. A rota principal é `/product`, com métodos para listar, adicionar, buscar por ID, atualizar e excluir produtos.

### Estrutura do Payload

```json
{
    "name":"Caixa de leite",
    "price": 12.44,
    "description":"2L",
    "validity": "07/05/2024",
    "image":"https://image.jpg"
}
```

---

## Endpoints

### 1. **Criar Produto**

- **Método:** `POST`
- **Rota:** `/products`
- **Descrição:** Cria um novo produto.
- **Request Body:**
  ```json
  {
    "name":"Caixa de leite",
    "price": 12.44,
    "description":"2L",
    "validity": "07/05/2024",
    "image":"https://image.jpg"
  }
  ```
- **Response:**
  - **Status:** `201 Created`
  - **Body:** Retorna os detalhes do produto criado com o ID gerado.
  ```json
  {
    "id": 1,
    "name":"Caixa de leite",
    "price": 12.44,
    "description":"2L",
    "validity": "07/05/2024",
    "image":"https://image.jpg"
  }
  ```

---

### 2. **Listar Todos os Produtos**

- **Método:** `GET`
- **Rota:** `/products`
- **Descrição:** Retorna uma lista de todos os produtos cadastrados.
- **Response:**
  - **Status:** `200 OK`
  - **Body:** Uma lista de produtos.
  ```json
  [
    {
      "id": 1,
      "name":"Caixa de leite",
      "price": 12.44,
      "description":"2L",
      "validity": "07/05/2024",
      "image":"https://image.jpg"
    },
    {
      "id": 2,
      "name":"Caixa de bombom",
      "price": 15.99,
      "description":"200G",
      "validity": "03/09/2025",
      "image":"https://image.jpg"
    }
  ]
  ```

---

### 3. **Buscar Produto por ID**

- **Método:** `GET`
- **Rota:** `/products/{id}`
- **Descrição:** Retorna os detalhes de um produto específico, identificado pelo seu ID.
- **Parâmetros de Rota:**
  - `id` (obrigatório): O ID do produto a ser buscado.
- **Response:**
  - **Status:** `200 OK`
  - **Body:** Detalhes do produto.
  ```json
    {
      "id": 1,
      "name":"Caixa de leite",
      "price": 12.44,
      "description":"2L",
      "validity": "07/05/2024",
      "image":"https://image.jpg"
    }
  ```
  - **Erro:**
    - **Status:** `404 Not Found`
    - **Body:** Produto não encontrado.

---

### 4. **Atualizar Produto**

- **Método:** `PUT`
- **Rota:** `/products/{id}`
- **Descrição:** Atualiza os detalhes de um produto específico.
- **Parâmetros de Rota:**
  - `id` (obrigatório): O ID do produto a ser atualizado.
- **Request Body:**
  ```json
    {
      "name":"Caixa de leite",
      "price": 10.44,
      "description":"2L",
      "validity": "07/05/2024",
      "image":"https://image.jpg"
    }
  ```
- **Response:**
  - **Status:** `200 OK`
  - **Body:** Detalhes do produto atualizado.
  ```json
    {
      "id": 1,
      "name":"Caixa de leite",
      "price": 10.44,
      "description":"2L",
      "validity": "07/05/2024",
      "image":"https://image.jpg"
    }
  ```
  - **Erro:**
    - **Status:** `404 Not Found`
    - **Body:** Produto não encontrado.

---

### 5. **Excluir Produto**

- **Método:** `DELETE`
- **Rota:** `/products/{id}`
- **Descrição:** Exclui um produto específico identificado pelo seu ID.
- **Parâmetros de Rota:**
  - `id` (obrigatório): O ID do produto a ser excluído.
- **Response:**
  - **Status:** `200 OK`
  - **Body:** Detalhes do produto atualizado.
  ```json
    {
      "id": 1,
      "name":"Caixa de leite",
      "price": 12.44,
      "description":"2L",
      "validity": "07/05/2024",
      "image":"https://image.jpg"
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


