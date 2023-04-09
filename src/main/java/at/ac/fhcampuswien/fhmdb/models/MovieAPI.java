package at.ac.fhcampuswien.fhmdb.models;

import at.ac.fhcampuswien.fhmdb.Genre;
import at.ac.fhcampuswien.fhmdb.Movie;
import okhttp3.*;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MovieAPI{

    private static final String URL = "https://prog2.fh-campuswien.ac.at/movies";

    private static String urlBuilder(String query, Genre genre, String releaseYear, String ratingFrom) {

        StringBuilder url = new StringBuilder(URL);

        if ((!query.isEmpty() && query != null) || genre != null && releaseYear != null && ratingFrom != null) {
            url.append("?");
        }
        if (!query.isEmpty() && query != null) {
            url.append("query=").append(query).append("&");
        }
        if (genre != null) {
            url.append("genre=").append(genre).append("&");
        }
        if (releaseYear != null) {
            url.append("releaseYear=").append(releaseYear).append("&");
        }
        if (ratingFrom != null) {
            url.append("ratingFrom=").append(ratingFrom);
        }
        return url.toString();
    }
    static OkHttpClient client = new OkHttpClient();

    public static List<Movie> getAllMovies(String query, Genre genre, String releaseYear, String ratingFrom) {

        String url = urlBuilder(query, genre, releaseYear, ratingFrom);

        Request request = new Request.Builder()
                .url(url)
                .removeHeader("User-Agent")
                .addHeader("User-Agent","http-agent")
                .build();

        try(Response response = client.newCall(request).execute()) {
            Gson gson = new Gson();
            Movie[] movie = gson.fromJson(response.body().string(), Movie[].class);
            return Arrays.asList(movie);

        }catch(Exception e){
            System.err.println(e.getMessage());
        }

        return new ArrayList<>();
    }

}
