# Projeto

Este projeto foi gerado usando o [Angular CLI](https://github.com/angular/angular-cli) versão 20.3.6.

## Servidor de desenvolvimento

Para iniciar um servidor de desenvolvimento local, execute:
# Projeto Perfumaria

Este repositório contém o front-end em Angular que consome uma API de perfumes (backend em Spring Boot). O backend está sendo executado via IntelliJ usando Maven.

> Observação: este README assume que o backend roda em `http://localhost:8080` (Spring Boot) e o frontend em `http://localhost:4200` (Angular). Ajuste as URLs quando necessário.

## Pré-requisitos
- Java 11+ e Maven
- Node.js 16+ e npm
- IntelliJ (recomendado) para executar o backend
- VS Code ou outra IDE para o frontend
- Postman (opcional) para testar endpoints

## Estrutura importante
- Backend (Spring Boot): projeto Java com controller em `/perfumes`.
- Frontend (Angular): pasta do projeto com `package.json` e `src/`.
- Serviço Angular que consome a API: `src/app/services/perfume.service.ts`.

## Endpoints da API (padrão Spring Boot)
- GET /perfumes — lista todos os perfumes
- GET /perfumes/{id} — obtém por id
- POST /perfumes — cria um perfume
- PUT /perfumes/{id} — atualiza um perfume
- DELETE /perfumes/{id} — remove um perfume

O controller do backend já possui CORS habilitado para o frontend:

```java
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/perfumes")
public class PerfumeController { ... }
```

## Rodando o backend (Maven / IntelliJ)
1. Abra o projeto backend no IntelliJ.
2. Execute a aplicação Spring Boot (Run na classe principal).

Ou via terminal (na pasta do backend):

```powershell
# maven
mvn spring-boot:run
```

Verifique no console do Spring Boot se o servidor subiu em `http://localhost:8080`.

## Rodando o frontend (Angular)
Na pasta raiz do frontend (onde está `package.json`):

```powershell
npm install
npm start
```

Abra no navegador: `http://localhost:4200` e navegue para `/produtos`.

## Ajuste da URL da API no frontend
Se o backend estiver rodando no Spring Boot (porta 8080), atualize o `PerfumeService` para apontar para a URL correta:

```ts
// src/app/services/perfume.service.ts
API_URL = "http://localhost:8080/perfumes";
```

## Popular a API (Postman / PowerShell)
Exemplo de JSON para criar um perfume (use Content-Type: application/json):

```json
{
	"nome": "Acqua Di Gio",
	"marca": "Giorgio Armani",
	"nacionalidade": "Itália",
	"img": "https://example.com/acqua_di_gio.jpg",
	"preco": 350.00
}
```

Use o Postman para cadastrar os perfumes:

1. Abra o Postman.
2. Crie uma nova requisição HTTP do tipo POST para `http://localhost:8080/perfumes`.
3. Em Headers adicione `Content-Type: application/json`.
4. Em Body selecione `raw` e cole o JSON de exemplo (veja acima).
5. Clique em Send — a API deve retornar o objeto criado.

## Debug rápido (se a lista não aparecer)
1. Verifique se o backend está rodando: abra `http://localhost:8080/perfumes` no navegador — deve retornar JSON.
2. No navegador com o frontend aberto, pressione F12 → aba Network. Navegue para `/produtos` e observe se há um GET para `http://localhost:8080/perfumes` e o status (200).
3. Se a requisição falhar por CORS, verifique se o `@CrossOrigin` está correto no backend.
4. Se a requisição retornar 200 mas os cards não aparecem, abra o Console (F12) e confira erros JavaScript.

## Captura de tela

![Captura de tela do Projeto Perfumaria](https://github.com/MariaAlineMees/API-Perfumes/blob/main/ng-consumer/Captura%20de%20tela%20Projeto%20Perfumaria.png)

