package com.sherif.marvelcharacters.ui.main;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.sherif.marvelcharacters.Util.MarvelApiConfig;
import com.sherif.marvelcharacters.Util.MarvelApiException;
import com.sherif.marvelcharacters.data.CharacterInterface;
import com.sherif.marvelcharacters.pojo.CharacterModel;
import com.sherif.marvelcharacters.pojo.CharactersModel;
import com.sherif.marvelcharacters.pojo.MarvelResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CharacterViewModel extends ViewModel {

    MutableLiveData<List<CharacterModel>> charactersMutableLiveData = new MutableLiveData<>();

    public void getCharacter(){
        MarvelApiConfig marvelApiConfig = new MarvelApiConfig.Builder("99cf13b0d9415beceb33c46ed9b89aa5", "7c302e0b494ce261ecb4bd27db610f14dea50e37").build();
        final CharacterInterface characterInterface = marvelApiConfig.getRetrofit().create(CharacterInterface.class);
        Call<MarvelResponse<CharactersModel>> call = characterInterface.getCharacters();
        call.enqueue(new Callback<MarvelResponse<CharactersModel>>() {
            @Override
            public void onResponse(Call<MarvelResponse<CharactersModel>> call, Response<MarvelResponse<CharactersModel>> response) {
                charactersMutableLiveData.setValue(response.body().getResponse().getCharacters());
            }

            @Override
            public void onFailure(Call<MarvelResponse<CharactersModel>> call, Throwable t) {

            }
        });
    }


}
