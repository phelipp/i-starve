package pndtech.com.istarve.Util.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import pndtech.com.istarve.Data.Produto;
import pndtech.com.istarve.R;

public class AdapterCardLoja extends RecyclerView.Adapter<AdapterCardLoja.MyViewHolder> {
    private List<Produto> produtos;
    private Context context;


    public AdapterCardLoja(List<Produto> produtos, Context context) {
        this.produtos = produtos;
        this.context = context;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.card_loja, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.name.setText(produtos.get(position).getName());
        holder.value.setText(produtos.get(position).getValueCurrency());
        holder.description.setText(produtos.get(position).getDescription());
        Picasso.get().load(produtos.get(position).getImageUrl()).into(holder.image);

    }

    @Override
    public int getItemCount() {
        return produtos.size();
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        TextView value;
        TextView description;
        ImageView image;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            value = itemView.findViewById(R.id.value);
            description = itemView.findViewById(R.id.description);

            image = itemView.findViewById(R.id.image);
        }
    }
}
