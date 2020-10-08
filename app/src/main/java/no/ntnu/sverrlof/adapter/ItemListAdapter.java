package no.ntnu.sverrlof.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import no.ntnu.sverrlof.R;
import no.ntnu.sverrlof.model.Item;

public class ItemListAdapter extends RecyclerView.Adapter<ItemListAdapter.ViewHolder> {


    private ArrayList<Item> items = new ArrayList<>();
    private Context context;

    public ItemListAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_specitem, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.itemTitleView.setText(items.get(position).getItemName());
        holder.itemPriceView.setText("Price: " + items.get(position).getPrice() + "kr");
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Enter specific item
              //  Toast.makeText(context, items.get(position).getItemName(), Toast.LENGTH_SHORT).show();

               // Item item = items.get(position);

            }
        });

        Glide.with(context)
                .asBitmap()
                .load("https://picsum.photos/200")
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView itemTitleView, itemPriceView;
        private CardView parent;
        private ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            parent = itemView.findViewById(R.id.recycleViewParent);
            itemTitleView = itemView.findViewById(R.id.itemTitleView);
            itemPriceView = itemView.findViewById(R.id.itemPriceView);

            imageView = itemView.findViewById(R.id.image);
        }
    }


}
