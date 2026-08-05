# Weather API Java — Dashboard Climatico

![Java](https://img.shields.io/badge/Java-24-orange?style=for-the-badge&logo=openjdk)
![Swing](https://img.shields.io/badge/UI-Java%20Swing-blue?style=for-the-badge)
![HttpClient](https://img.shields.io/badge/HTTP-java.net.http-red?style=for-the-badge)
![License](https://img.shields.io/badge/License-MIT-green?style=for-the-badge)

Uma aplicação desktop moderna e responsiva desenvolvida em Java 24 para consulta de condições meteorológicas em tempo real. O projeto realiza requisições assíncronas a serviços de geocodificação e previsão do tempo, processando os dados retornados em formato JSON e apresentando-os em uma interface gráfica amigável.

---

## Funcionalidades

- **Busca por Cidade:** Permite consultar o clima de qualquer localidade através da API de geocodificação do Open-Meteo.
- **Execução Assíncrona:** Requisições HTTP executadas em threads secundárias utilizando os recursos modernos do Java 24 para manter a interface gráfica fluida e sem travamentos (Swing Thread Safety).
- **Exibição em Tempo Real:** Apresenta temperatura atual em °C, velocidade do vento em km/h e indicadores visuais.
- **Tratamento de Erros:** Notificações visuais amigáveis via JOptionPane para cenários de cidade não encontrada ou falhas de conexão.

---

## Mapeamento de Emojis e Indicadores da Interface

A interface do programa utiliza emojis no componente `labelEmoji` para indicar o estado do tempo atualizado dinamicamente com base nas respostas da API:

| Emoji | Condição Meteorológica | Descrição |
| :---: | :--- | :--- |
| ☀️ | Céu Limpo / Ensolarado | Exibido por padrão e em respostas que indicam ausência de nuvens. |
| ⛅ | Parcialmente Nublado | Exibido para variações moderadas de nebulosidade. |
| 🌧️ | Chuva / Garoa | Exibido quando a resposta da API retorna códigos de precipitação. |
| 🌩️ | Tempestade | Exibido para eventos meteorológicos com atividade elétrica. |

---

## Arquitetura e Fluxo de Dados

O fluxo de execução do sistema segue o modelo de comunicação desacoplado entre a camada visual (GUI) e a camada de serviço/HTTP:

```text
+-------------------+        +-------------------+        +-----------------------------------+
|   Usuario (GUI)   | ---->  |  InterfaceClima   | ---->  |             Principal             |
|  [Digita Cidade]  |        |  (Event Listener) |        | (Java 24 Thread Exec. Asincrona) |
+-------------------+        +-------------------+        +-----------------------------------+
                                                                            |
                                                                            v
+-------------------+        +-------------------+        +-----------------------------------+
| InterfaceClima    | <----  |  Parse do JSON    | <----  |       Open-Meteo & Geo API        |
| (atualizarDados)  |        |  (org.json)       |        | (java.net.http.HttpClient)        |
+-------------------+        +-------------------+        +-----------------------------------+
```
Tecnologias UtilizadasTecnologiaDescriçãoJava 24Linguagem base e plataforma de execução do projeto.Java Swing / AWTConstrução da interface gráfica do usuário (GUI).java.net.http.HttpClientCliente HTTP nativo do Java para consumo de APIs RESTful.org.json (JSON-Java)Biblioteca para parsing e extração de dados da resposta JSON.Open-Meteo API API gratuita para dados geográficos e meteorológicos em tempo real.Como Executar o ProjetoPré-requisitosJDK 24 instalado e configurado nas variáveis de ambiente.Apache Maven instalado e configurado no PATH.Passos para execuçãoClone este repositório:Bashgit clone [https://github.com/andredejesus-dev/weather-api-java.git](https://github.com/andredejesus-dev/weather-api-java.git)

Acesse a pasta do projeto:Bashcd weather-api-java

Compile e execute via Maven:Bashmvn clean compile exec:java -Dexec.mainClass="Principal"

Autor:Desenvolvido por André de Jesus — GitHub
