package com.sherif.marvelcharacters.data;

import com.sherif.marvelcharacters.pojo.CharacterModel;
import com.sherif.marvelcharacters.pojo.CharactersModel;
import com.sherif.marvelcharacters.pojo.MarvelResponse;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

public interface CharacterInterface {

//    @GET("characters")
//    Call<List<CharacterModel>> getCharacters();
    @GET("characters") Call<MarvelResponse<CharactersModel>> getCharacters();

    @GET("characters/{id}") Call<MarvelResponse<CharacterModel>> getCharacter(
            @Path("id") String characterId);
}
