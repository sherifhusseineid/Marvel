package com.sherif.marvelcharacters.ui.main;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.sherif.marvelcharacters.R;
import com.sherif.marvelcharacters.pojo.CharacterModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    CharacterViewModel characterViewModel;
    CharacterAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar);

        characterViewModel = ViewModelProviders.of(this).get(CharacterViewModel.class);

        characterViewModel.getCharacter();
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        adapter = new CharacterAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        characterViewModel.charactersMutableLiveData.observe(this, new Observer<List<CharacterModel>>() {
            @Override
            public void onChanged(List<CharacterModel> characterModels) {
                adapter.setList(characterModels);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //super.onCreateOptionsMenu(menu, inflater);
        getMenuInflater().inflate(R.menu.menu, menu);
        androidx.appcompat.widget.SearchView searchView = (androidx.appcompat.widget.SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.search) {

        }
        return super.onOptionsItemSelected(item);
    }
}