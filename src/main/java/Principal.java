import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Principal {

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            new InterfaceClima().setVisible(true);
        });
    }

    public static void buscarDadosParaTela(String cidade, InterfaceClima tela) {
        new Thread(() -> {
            try {
                HttpClient client = HttpClient.newHttpClient();

                String urlGeo = "https://geocoding-api.open-meteo.com/v1/search?name="
                        + cidade.replace(" ", "+") + "&count=1";

                HttpRequest reqGeo = HttpRequest.newBuilder()
                        .uri(URI.create(urlGeo))
                        .build();

                String resGeo = client.send(reqGeo, HttpResponse.BodyHandlers.ofString()).body();

                JSONObject jsonGeo = new JSONObject(resGeo);

                if (jsonGeo.has("results") && jsonGeo.getJSONArray("results").length() > 0) {
                    JSONObject local = jsonGeo.getJSONArray("results").getJSONObject(0);

                    double lat = local.getDouble("latitude");
                    double lon = local.getDouble("longitude");
                    String nomeOficial = local.getString("name");

                    String urlClima = String.format(java.util.Locale.US,
                            "https://api.open-meteo.com/v1/forecast?latitude=%f&longitude=%f&current_weather=true",
                            lat, lon);

                    HttpRequest reqClima = HttpRequest.newBuilder()
                            .uri(URI.create(urlClima))
                            .build();

                    String resClima = client.send(reqClima, HttpResponse.BodyHandlers.ofString()).body();

                    JSONObject current = new JSONObject(resClima).getJSONObject("current_weather");

                    double temp = current.getDouble("temperature");
                    double vento = current.getDouble("windspeed");

                    tela.atualizarCampos(temp, vento, nomeOficial);

                } else {
                    tela.mostrarErro("Cidade não encontrada.");
                }

            } catch (Exception e) {
                tela.mostrarErro("Erro ao buscar dados.");
                e.printStackTrace();
            }
        }).start();
    }
}