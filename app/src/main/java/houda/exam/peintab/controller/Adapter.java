package houda.exam.peintab.controller;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import houda.exam.peintab.globel.Constants;
import houda.exam.peintab.model.Peintab;
import houda.exam.peintab.R;

public class Adapter extends RecyclerView.Adapter<Adapter.TabViewHolder> {

    ArrayList<Peintab> peintList;
    Context context;

    public Adapter() {
    }

    public Adapter(ArrayList<Peintab> peintList, Context context) {
        this.peintList = peintList;
        this.context = context;
    }

    @NonNull
    @Override
    public Adapter.TabViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_peintab,parent,false);
        return new TabViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.TabViewHolder holder, int position) {
    final Peintab PT = peintList.get(position);

    holder.p_tab.setImageResource(PT.getImg_tb());
    holder.titre_tab.setText(PT.getTitre());
    holder.artist_tab.setText(PT.getArtist());
    holder.itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //context ena win majoud
            Intent intent=new Intent(context, Details.class);

            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.putExtra(Constants.INTENT_PUT_IMAGE,PT.getImg_tb());
            intent.putExtra(Constants.INTENT_PUT_TITILE,PT.getTitre());
            intent.putExtra(Constants.INTENT_PUT_PAINTER,PT.getArtist());
            intent.putExtra(Constants.INTENT_PUT_DATE,PT.getDate());
            intent.putExtra(Constants.INTENT_PUT_DESCRIPTION,PT.getDescription());
            context.startActivity(intent);

        }
    });
    }

    @Override
    public int getItemCount() {
        return peintList.size();
    }

    public static class TabViewHolder extends RecyclerView.ViewHolder {

        ImageView p_tab;
        TextView titre_tab, artist_tab;
        public TabViewHolder(@NonNull View itemView) {

            super(itemView);

            p_tab = itemView.findViewById(R.id.tableau);
            titre_tab=itemView.findViewById(R.id.titre);
            artist_tab=itemView.findViewById(R.id.artist);


        }
    }
}
