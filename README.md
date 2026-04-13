## 🏗️ Diagrama do Sistema (ASCII)

## 🏗️ Diagrama do Sistema

```
+---------------------------+
|     InterfaceClima        |
+---------------------------+
| - campoCidade             |
| - labelTemperatura        |
| - labelVento              |
| - labelCidade             |
| - labelEmoji              |
+---------------------------+
| + atualizarCampos()       |
| + mostrarErro()           |
+---------------------------+
             |
             v
+-------------------------------+
|          Principal            |
+-------------------------------+
| + main()                      |
| + buscarDadosParaTela()       |
+-------------------------------+
             |
             v
+------------------------------------------+
| API Geocoding (Open-Meteo)               |
| GET /v1/search?name=cidade               |
+------------------------------------------+
             |
             v
+------------------------------------------+
| API Clima (Open-Meteo)                   |
| GET /v1/forecast?latitude&longitude      |
+------------------------------------------+
             |
             v
+---------------------------+
|     InterfaceClima        |
|  (Exibe os dados)         |
+---------------------------+
```

## 📁 Estrutura do Projeto

```
ApiTempo/
├── src/
│   ├── InterfaceClima.java
│   ├── Principal.java
├── pom.xml
└── README.md
```

# 🌦️ App de Clima em Java

Aplicação desktop desenvolvida em Java com Swing que consome a API Open-Meteo para exibir informações climáticas em tempo real de qualquer cidade.

---

## 🚀 Funcionalidades

- 🔍 Busca de cidade por nome
- 🌡️ Exibição da temperatura atual
- 💨 Velocidade do vento
- 📍 Identificação da localização
- 🌤️ Emoji dinâmico baseado nas condições climáticas
- ⚠️ Tratamento de erros para entradas inválidas

---

## 🛠 Tecnologias utilizadas

- Java
- Swing (Interface gráfica)
- API Open-Meteo
- JSON (manipulação de dados)

---

## 🧠 Arquitetura do projeto

O sistema segue uma separação simples entre interface, lógica e consumo de API:

- `InterfaceClima`: responsável pela interface gráfica e exibição dos dados  
- `Principal`: controla o fluxo da aplicação e integração com APIs externas  

---

## ▶️ Como executar

1. Clone o repositório:
```bash
git clone https://github.com/andredejesus-dev/ApiTempo.git
