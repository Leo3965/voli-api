package med.voli.api.domain.adapter;

import java.io.IOException;
import java.net.URL;
import java.util.Map;

public class HttpClient implements HttpAdapter{
    @Override
    public void post(String url, Map<String, Object> dados) {
        try {
            var urlApi = new URL(url);
            var connection = urlApi.openConnection();
            connection.connect();
        } catch (IOException e) {
            throw new RuntimeException("Erro ao enviar requisição HTTP", e);
        }
    }
}
