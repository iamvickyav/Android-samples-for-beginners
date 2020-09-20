package com.iamvickyav.randomquote;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by JARVIS on 23-09-2017.
 */

public interface QuoteService {

    @GET("/wp-json/posts?filter[orderby]=rand&filter[posts_per_page]=1")
    Call<List<Quote>> getRandomQuote();
}
