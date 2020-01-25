package com.sherif.marvelcharacters.ui.main;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.sherif.marvelcharacters.R;
import com.sherif.marvelcharacters.pojo.CharacterModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder> implements Filterable {
    private List<CharacterModel> characterList = new ArrayList<>();
    private ArrayList<CharacterModel> characterListFull = new ArrayList<>();



    @NonNull
    @Override
    public CharacterAdapter.CharacterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CharacterViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.character_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CharacterAdapter.CharacterViewHolder holder, int position) {
        Picasso.get().load(characterList.get(position).getThumbnail().getImageUrl()).into(holder.characterThumbnail);
        holder.characterName.setText(characterList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return characterList.size();
    }

    public void setList(List<CharacterModel> characterList) {
        this.characterList = characterList;
        characterListFull.addAll(characterList);
        notifyDataSetChanged();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                constraint = constraint.toString().toLowerCase().trim();
                characterList.clear();
                if (constraint.length() == 0){
                    characterList.addAll(characterListFull);
                }
                else {
                    for (CharacterModel item : characterListFull){
                        if (item.getName().toLowerCase(Locale.getDefault()).contains(constraint)){
                            characterList.add(item);
                        }

                    }
                }
                FilterResults results = new FilterResults();
                results.values = characterList;

                return results;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                notifyDataSetChanged();
            }
        };
    }

    public class CharacterViewHolder extends RecyclerView.ViewHolder {
        ImageView characterThumbnail;
        TextView characterName;

        public CharacterViewHolder(@NonNull View itemView) {
            super(itemView);
            characterThumbnail = itemView.findViewById(R.id.character_thumbnail);
            characterName = itemView.findViewById(R.id.character_name);
        }
    }
}
