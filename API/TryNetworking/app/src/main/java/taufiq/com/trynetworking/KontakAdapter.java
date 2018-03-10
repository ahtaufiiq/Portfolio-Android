package taufiq.com.trynetworking;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.LinkedList;

/**
 * Created by taufiq on 25/02/18.
 */

public class KontakAdapter extends RecyclerView.Adapter<KontakAdapter.ViewHolder> {

    private final LinkedList<Kontak> listItems;
    private Context context;

    //create constructor
    public KontakAdapter(LinkedList<Kontak> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }


    @Override
    public KontakAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(KontakAdapter.ViewHolder holder, int position) {

        final Kontak listItem = listItems.get(position);

        //set Text title to screen
        holder.textViewTitle.setText(listItem.getId());
        //set text to description view
        holder.textViewDescription.setText(listItem.getNama());
        //set background for list item
        holder.textNomor.setText(listItem.getNomor());

        //if click cardView intent to detailActivity and putextra data title, description, and foto
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("title", listItem.getId());
                intent.putExtra("description", listItem.getNama());
                intent.putExtra("foto", listItem.getNomor());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        //check ukuran listItems
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewTitle;
        public TextView textViewDescription;
        public TextView textNomor;
        public LinearLayout linearLayout;
        public CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);

            //find View in layout
            textViewTitle = itemView.findViewById(R.id.titleProduct);
            textViewDescription = itemView.findViewById(R.id.description);
            textNomor=itemView.findViewById(R.id.nomor);
            cardView = itemView.findViewById(R.id.cardView);
            linearLayout = itemView.findViewById(R.id.linearLayout);
        }
    }
}
