package com.iamdilipkumar.movies.movies.utilities;

import android.content.res.Resources;
import android.net.Uri;

import com.iamdilipkumar.movies.movies.R;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * Created on 20/03/17.
 * @author dilipkumar4813
 * @version 1.0
 *
 * This utility class will be used to connect with the movies api
 * Fetch the results based on sort order
 */

public class NetworkUtils {

    private final static String MOVIEDB_BASE_URL = "";

    private final static String PARAM_API = "api_key";

    /**
     *  Builds the url with the sort order and api key
     *
     * @param sortingOrder string that specifies the sort order
     * @return URL returns the built URL
     * @throws MalformedURLException Related to malformed URL
     */
    public static URL buildUrl(String sortingOrder) throws MalformedURLException {
        Uri builtUri = Uri.parse(MOVIEDB_BASE_URL+sortingOrder).buildUpon()
                .appendQueryParameter(PARAM_API, Resources.getSystem().getString(R.string.movie_api_key))
                .build();

        return new URL(builtUri.toString());
    }

    /**
     * Fetch data from the url provided
     *
     * @param url The url from which the data has to be
     * @return String response from the url
     * @throws IOException Related to network and stream reading
     */
    public static String getMoviesListFromHttpUrl(URL url) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        try {
            InputStream in = connection.getInputStream();

            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\A");

            boolean hasResults = scanner.hasNext();

            if (hasResults) {
                return scanner.next();
            } else {
                return null;
            }
        } finally {
            connection.disconnect();
        }

    }

}