package com.sherif.marvelcharacters.pojo;

import java.util.List;

public class CharactersModel extends MarvelCollectionModel<CharacterModel> {

    public List<CharacterModel> getCharacters() {
        return getResults();
    }

    @Override public String toString() {
        return "CharactersDto{"
                + "offset="
                + getOffset()
                + ", limit="
                + getLimit()
                + ", total="
                + getTotal()
                + ", count="
                + getCount()
                + ", characters="
                + getCharacters().toString()
                + '}';
    }
}
