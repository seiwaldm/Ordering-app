package de.androidnewcomer.order_app;

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

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Product> list;

    public ProductAdapter(Context context, ArrayList<Product> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ProductAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.product_recycler_design, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.ViewHolder holder, int position) {
        holder.img.setImageResource(list.get(position).getProductImage());
        holder.name.setText(list.get(position).getProductName());
        holder.price.setText(Integer.toString(list.get(position).getProductPrice()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView name,price;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.image_product_design);
            name = itemView.findViewById(R.id.product_name);
            price = itemView.findViewById(R.id.product_price);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = getAdapterPosition();
                    Intent intent = new Intent(new Intent(context, ProductCheckout.class));

                    intent.putExtra("PImage",list.get(pos).getProductImage());
                    intent.putExtra("PName",list.get(pos).getProductName());
                    intent.putExtra("PPrice",list.get(pos).getProductPrice());
                    intent.putExtra("PQty",list.get(pos).getProductQty());
                    context.startActivity(intent);
                }
            });

        }
    }
}

