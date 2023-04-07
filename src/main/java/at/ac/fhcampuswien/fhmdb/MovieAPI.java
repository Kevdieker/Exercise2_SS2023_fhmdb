package at.ac.fhcampuswien.fhmdb;

import okhttp3.*;
public class MovieAPI{

    private final String URL = "https://prog2.fh-campuswien.ac.at/movies";

    private String urlBuilder(String query, Genre genre, String releaseYear, String ratingFrom) {

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

    OkHttpClient client = new OkHttpClient();

}
