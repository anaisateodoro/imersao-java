import java.io.InputStream;

import java.net.URL;

import java.util.List;


public class App {
    public static void main(String[] args) throws Exception {
        
        //fazer uma conexão HTTP e buscar os top 250 filmes
        // String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/MostPopularMovies.json"; // usando endereço alternativo
        // ExtratorDeConteudo extrator = new ExtratorDeConteudoDoIMDB();
      
      
        String url = "https://api.nasa.gov/planetary/apod?api_key=O7zKxnW2shXRvSoisSrMCe1JTt3RZi1C5mc8K18b&start_date=2022-06-12&end_date=2022-06-14"; // ApikeyNasa
        ExtratorDeConteudo extrator = new ExtratorDeConteudoDaNasa();

        var http = new ClienteHttp();
        String json = http.buscaDados(url);        
      
        // exibir e manipular dados
       
        List<Conteudo> conteudos = extrator.extraiConteudos(json);


        var geradora = new GeradoraDeFigurinhas();

        for (int i=0;i<3;i++){
        
            Conteudo conteudo = conteudos.get(i);

            InputStream inputStream = new URL(conteudo.urlImagem()).openStream();
            String nomeArquivo = "saida/"+ conteudo.titulo() + ".png";

            geradora.cria(inputStream, nomeArquivo);

            System.out.println(conteudo.titulo());
            System.out.println();

    }


    }
}
