package com.example.recyclerviewdemo;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.*;
import android.widget.TextView;
import android.widget.Toast;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private final String[] localDataSet;

    /** Garde les références vers les vues d'une ligne. */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;

        public ViewHolder(View view) {
            super(view);
            textView = view.findViewById(R.id.textView);
        }

        public TextView getTextView() {
            return textView;
        }
    }

    public CustomAdapter(String[] dataSet) {
        localDataSet = dataSet;
    }

    // Crée une nouvelle ligne (appelé par le LayoutManager)
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.text_row_item, viewGroup, false);
        return new ViewHolder(view);
    }

    // Remplit une ligne avec la donnée à la position donnée
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int position) {
        viewHolder.getTextView().setText(localDataSet[position]);

        viewHolder.itemView.setOnClickListener(v ->
                Toast.makeText(v.getContext(),
                        "Clic sur : " + localDataSet[viewHolder.getAdapterPosition()],
                        Toast.LENGTH_SHORT).show());
    }

    @Override
    public int getItemCount() {
        return localDataSet.length;
    }
}