# 📌 PISCICLEAN
### Equipe: Patricia Morais da Silva, Hian Rick e Katleen Martins
O principal desafio do nosso cliente, que trabalha com tratamento de piscinas, é a perda de tempo ao precisar responder dúvidas durante o dia, justamente enquanto está atendendo presencialmente seus próprios clientes. Atualmente ele auxilia seus clientes via whatsapp, marca de limpar suas piscinas e tira dúvidas por esse canal.
Nosso solução para esta questão se trata do desenvolvimento de um App Mobile com inteligência artificial onde o usuário poderá enviar foto da sua piscina e relatar seu problema. O sistema ajudará identificando a condição da água e avaliando a situação da piscina do usuário, gerando assim um plano de tratamento personalizado.
Neste app a usuário também pode solicitar os serviços do nosso cliente, fornecendo seu endereço, descrição do problema e telefone de contato. Claro, após ele realizar seu cadastro/login.

---

## 🚀 Tecnologias Utilizadas

- **React Native**
- **Expo**
- **Axios**
- **React Navigation**
- **AsyncStorage**
- **Node.js**
- **Java / Spring Boot**
- **PostgreSQL**
---
## 📂 Estrutura do Projeto

```txt
.
├── .mvn
│   └── wrapper
│       └── maven-wrapper.properties
│
├── src
│   ├── main
│   │   ├── java/com/example/backend_p...
│   │   │   ├── controllers
│   │   │   │   ├── ClienteController.java
│   │   │   │   ├── ConversaController.java
│   │   │   │   ├── MensagemController.java
│   │   │   │   └── ServicoController.java
│   │   │   │
│   │   │   ├── dtos
│   │   │   │   ├── ClienteDTO.java
│   │   │   │   ├── ClienteLoginDTO.java
│   │   │   │   ├── ClienteOutputDTO.java
│   │   │   │   ├── ConversaCreateDTO.java
│   │   │   │   ├── ConversaDTO.java
│   │   │   │   ├── MensagemCreateDTO.java
│   │   │   │   ├── MensagemDTO.java
│   │   │   │   ├── ServicoCreateDTO.java
│   │   │   │   ├── ServicoDTO.java
│   │   │   │   ├── ServicoUpdateConcluidoDTO.java
│   │   │   │   └── UpdateStatusRequest.java
│   │   │   │
│   │   │   ├── entities
│   │   │   │   ├── enums
│   │   │   │   │   └── StatusServico.java
│   │   │   │   ├── Cliente.java
│   │   │   │   ├── Conversa.java
│   │   │   │   ├── Mensagem.java
│   │   │   │   ├── SecurityConfig.java
│   │   │   │   └── Servico.java
│   │   │   │
│   │   │   ├── mappers
│   │   │   │   ├── ClienteMapper.java
│   │   │   │   ├── ConversaMapper.java
│   │   │   │   ├── MensagemMapper.java
│   │   │   │   └── ServicoMapper.java
│   │   │   │
│   │   │   ├── repositories
│   │   │   │   ├── ClienteRepository.java
│   │   │   │   ├── ConversaRepository.java
│   │   │   │   ├── MensagemRepository.java
│   │   │   │   └── ServicoRepository.java
│   │   │   │
│   │   │   ├── services
│   │   │   │   ├── ClienteService.java
│   │   │   │   ├── ConversaService.java
│   │   │   │   ├── MensagemService.java
│   │   │   │   └── ServicoService.java
│   │   │   │
│   │   │   ├── BackendPiscinaApplication.java
│   │   │   └──  CorsConfig.java
│   │   │
│   │   └── resources
│   │       └── application.properties
│   │
│   └── test/java/com.example.backend_piscina
│       └── BackendPiscinaApplicationTests.java
│
├── .gitattributes
├── .gitignore
├── README.md
├── mvnw
├── mvnw.cmd
├── package-lock.json
└── pom.xml
```
---
## 📦Como executar o projeto
1. Clone o repositório do backend:

    ```bash
    git clone https://github.com/Katleenmm/backend-piscina.git
    cd backend-piscina
    ```

2. ▶️ Executar no IntelliJ

        Abra o IntelliJ IDEA

        Vá em File > Open e selecione a pasta backend-piscina

        Aguarde o IntelliJ baixar as dependências do Maven

        No painel lateral, abra:

        src/main/java/.../BackendPiscinaApplication.java

        Clique no botão Run ▶ para iniciar o servidor

        O backend iniciará em: http://localhost:8080

---
### 🖥️ FrontEnd (ReactNative com Expo)
1. Clone o repositorio

   ```bash
   git clone https://github.com/patriciamrs/projeto-psciclean.git
   cd projeto-psciclean
   ```

2. Instale as dependências

    ```bash
    npm install
    ```

3. Inicie o app com Expo

    ```bash
    npm expo start
    ```

4. Executar o app

   Você pode escolher:

   Pressionar a → abrir no emulador Android

   Pressionar w → abrir no navegador (modo web)

   Escanear o QR Code com o Expo Go no celular
---
## Apresentação
https://www.canva.com/design/DAG6SND6ruw/YVVhEm8KPS28yDAUBgodZg/edit?utm_content=DAG6SND6ruw&utm_campaign=designshare&utm_medium=link2&utm_source=sharebutton
