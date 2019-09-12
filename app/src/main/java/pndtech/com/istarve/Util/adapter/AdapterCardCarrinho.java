package pndtech.com.istarve.Util.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import pndtech.com.istarve.R;
import pndtech.com.istarve.Data.Item;
import pndtech.com.istarve.Util.Formats;

public class AdapterCardCarrinho extends RecyclerView.Adapter<AdapterCardCarrinho.MyViewHolder> {
    private List<Item> itens;
    private Context context;

    public AdapterCardCarrinho(List<Item> itens, Context context) {
        this.itens = itens;
        this.context = context;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.card_carrinho, parent, false);
        return new MyViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        float value = itens.get(position).getAmount() * itens.get(position).getProduto().getValue();
        holder.name.setText(itens.get(position).getProduto().getName());
        holder.amount.setText(itens.get(position).getAmount());
        holder.unitaryValue.setText(itens.get(position).getProduto().getValueCurrency());
        holder.value.setText(Formats.currency(value));
        Picasso.get().load(itens.get(position).getProduto().getImageUrl()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return itens.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView amount;
        TextView unitaryValue;
        TextView value;
        ImageView imageView;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
