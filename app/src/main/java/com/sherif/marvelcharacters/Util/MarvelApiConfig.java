package com.sherif.marvelcharacters.Util;


import com.sherif.marvelcharacters.data.CharacterInterface;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MarvelApiConfig {
    private static MarvelApiConfig singleton;
    private final String publicKey;
    private final String privateKey;
    private final Retrofit retrofit;


    MarvelApiConfig(String publicKey, String privateKey, Retrofit retrofit) {
        this.publicKey = publicKey;
        this.privateKey = privateKey;
        this.retrofit = retrofit;
    }

    public static MarvelApiConfig with (String publicKey, String privateKey) {
        if (singleton == null) {
            singleton = new Builder(publicKey, privateKey).build();
        }
        return singleton;
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }

    /**
     * Fluent API for creating {@link MarvelApiConfig} instances.
     */
    @SuppressWarnings("UnusedDeclaration") public static class Builder {

        private static final String MARVEL_API_BASE_URL = "https://gateway.marvel.com/v1/public/";
        private final String privateKey;
        private final String publicKey;
        private Retrofit retrofit;
        private String baseUrl = MARVEL_API_BASE_URL;
        private TimeProvider timeProvider = new TimeProvider();

        public Builder(String publicKey, String privateKey) {
            if (publicKey == null) {
                throw new IllegalArgumentException("publicKey must not be null.");
            }

            if (privateKey == null) {
                throw new IllegalArgumentException("privateKey must not be null.");
            }

            this.publicKey = publicKey;
            this.privateKey = privateKey;
        }

        public Builder baseUrl(String url) {
            this.baseUrl = url;
            return this;
        }

        public Builder retrofit(Retrofit retrofit) {
            if (retrofit == null) {
                throw new IllegalArgumentException("retrofit must not be null.");
            }
            this.retrofit = retrofit;
            return this;
        }

        public MarvelApiConfig build() {
            if (retrofit == null) {
                retrofit = buildRetrofit();
            }

            return new MarvelApiConfig(publicKey, privateKey, retrofit);
        }

        private Retrofit buildRetrofit() {
            CharacterInterface characterInterface;

            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient.Builder builder = new OkHttpClient.Builder()
                    .addInterceptor(new AuthInterceptor(publicKey, privateKey, timeProvider))
                    .addInterceptor(loggingInterceptor);

            OkHttpClient client = builder.build();

            return new Retrofit.Builder().baseUrl(baseUrl)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
    }
}
