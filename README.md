## 🏗️ Diagrama do Sistema (ASCII)

+---------------------------+
|     InterfaceClima        |
+---------------------------+
| - campoCidade: JTextField |
| - labelTemperatura        |
| - labelVento              |
| - labelCidade             |
| - labelEmoji              |
+---------------------------+
| + atualizarCampos()       |
| + mostrarErro()           |
+---------------------------+
             │
             │ chama
             ▼
+-------------------------------+
|          Principal            |
+-------------------------------+
|                               |
+-------------------------------+
| + main()                      |
| + buscarDadosParaTela()       |
+-------------------------------+
             │
             │ faz requisição HTTP (GET)
             ▼
+------------------------------------------+
|     API Geocoding (Open-Meteo)           |
+------------------------------------------+
| GET /v1/search?name=cidade               |
+------------------------------------------+
             │
             │ retorna JSON (lat, lon)
             ▼
+------------------------------------------+
|     API Clima (Open-Meteo)               |
+------------------------------------------+
| GET /v1/forecast?latitude&longitude      |
+------------------------------------------+
             │
             │ retorna JSON (temp, vento)
             ▼
+---------------------------+
|     InterfaceClima        |
+---------------------------+
| Exibe dados na tela       |
+---------------------------+


ApiTempo/
 ├── src/
 │   ├── InterfaceClima.java
 │   ├── Principal.java
 ├── pom.xml
 ├── README.md

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
