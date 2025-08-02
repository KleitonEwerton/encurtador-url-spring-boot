<h1 align="center">Encurtador de URLs com Spring Boot</h1>

<p align="center">
Projeto de back-end desenvolvido em Java com o framework Spring Boot para atender ao desafio de implementar um serviço de encurtamento de URLs.
</p>




<h1>Sobre a Aplicação</h1>


Esta aplicação é um serviço back-end projetado para encurtar URLs longas, tornando-as mais compactas e fáceis de compartilhar. O projeto implementa uma solução robusta, seguindo os requisitos de um desafio técnico, e serve como uma demonstração de habilidades em desenvolvimento back-end utilizando Java e o framework Spring Boot.

Funcionalidades e Requisitos Técnicos
A aplicação oferece uma API para encurtar URLs e gerenciar redirecionamentos. Os pontos-chave da implementação incluem:

Encurtamento de URL: A aplicação aceita uma URL longa via um endpoint POST e gera uma versão encurtada.

Formato do Encurtamento: A URL encurtada é composta por uma sequência de caracteres que pode ter entre 5 e 10 caracteres. Apenas letras e números são utilizados na geração da chave.

Persistência de Dados: As URLs encurtadas são salvas em um banco de dados, associadas à URL original e a um prazo de validade.

Redirecionamento Inteligente: Ao receber uma requisição para a URL encurtada, a aplicação realiza um redirecionamento (HTTP 302 Found) para a URL original. Se a URL não for encontrada ou estiver expirada, um status HTTP 404 (Not Found) é retornado.

O projeto demonstra a capacidade de construir um serviço RESTful eficiente e confiável, aplicando conceitos de persistência de dados, gerenciamento de requisições HTTP e tratamento de exceções.

## Exemplo

Seu serviço recebe uma chamada para encurtar uma URL.

**[POST]** `{{host}}/url/shorturl`

```json
{
    "url": "https://google.com"
}
```

E retorna um JSON com a URL encurtada:

```
HTTP/1.1 200 OK
```

```json
{
    "url": "https://shorturl.com/DXB6V"
}
```

Responsável
 - Kleiton Ewerton de Oliveira

📞 Contato
 - kleitonewertonoliveira@gmail.com
