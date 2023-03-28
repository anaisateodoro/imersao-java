import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        
        //fazer uma conexão HTTP e buscar os top 250 filmes
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/MostPopularMovies.json"; // usando endereço alternativo
        URI endereco = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request =   HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request,BodyHandlers.ofString());
        String body = response.body();
        
        // Parser os dados que nos interessam (titulo,poster,classificação)
        var parser = new JsonParser();
        List<Map<String,String>>listaDeFilmes = parser.parse(body);
      
        // exibir os dados que quisermos

        for (int i = 0;i<3;i++){
        Map<String,String> filme = listaDeFilmes.get(i); {
            System.out.println("\u001b[1mTítulo:\u001b[m " + filme.get("title"));
            System.out.println("\u001b[1mURL da Imagem:\u001b[m "+ filme.get("image"));
            double classificacao = Double.parseDouble(filme.get("imDbRating"));

        //imprimir estrelinhas
        int numeroEstrelinhas = (int) classificacao;
        for (int n = 1; n <= numeroEstrelinhas; n++) {
                System.out.print("\u2B50");
        }
        System.out.println("\n");
            
        }
    }

    }
}
