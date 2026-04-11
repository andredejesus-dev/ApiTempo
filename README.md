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

Aplicação desktop feita com Java Swing que consome a API Open-Meteo para mostrar:

- 🌡️ Temperatura atual
- 💨 Velocidade do vento
- 📍 Nome da cidade
- 🌤️ Emoji baseado no clima

## 🚀 Tecnologias
- Java
- Swing
- API Open-Meteo
- JSON

## 📸 Funcionalidade
Digite o nome de uma cidade e veja o clima em tempo real.

## ▶️ Como rodar
Execute a classe `Principal.java`
