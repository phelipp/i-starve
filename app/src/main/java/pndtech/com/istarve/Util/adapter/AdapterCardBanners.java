package pndtech.com.istarve.Util.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import pndtech.com.istarve.R;
import pndtech.com.istarve.Data.Banner;

public class AdapterCardBanners extends RecyclerView.Adapter<AdapterCardBanners.MyViewHolder> {

    private List<Banner> banners;
    private Context context;

    public AdapterCardBanners(Context context, List<Banner> banners) {
        this.context = context;
        this.banners = banners;
    }

    public List<Banner> getBanners() {
        return banners;
    }

    public void setBanners(List<Banner> banners) {
        this.banners = banners;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.card_banners, parent, false);
        return new MyViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        String url = banners.get(position).getUrlImage();
        Picasso.get().load(url).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return banners.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView image;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
        }
    }
}
