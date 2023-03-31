public enum API {
    
    IMDB_TOP_MOVIES ("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/MostPopularMovies.json", new ExtratorDeConteudoDoIMDB()),
    IMDB_TOP_SERIES("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopTVs.json", new ExtratorDeConteudoDoIMDB()),
    NASA ("https://api.nasa.gov/planetary/apod?api_key=O7zKxnW2shXRvSoisSrMCe1JTt3RZi1C5mc8K18b&start_date=2022-06-12&end_date=2022-06-14",new ExtratorDeConteudoDaNasa());

    private String url;
    private ExtratorDeConteudo extrator;
    
    API(String url, ExtratorDeConteudo extrator) {
        this.url = url;
        this.extrator = extrator;
    }

    public String getUrl() {
        return url;
    }

    public ExtratorDeConteudo getExtrator() {
        return extrator;
    }
}