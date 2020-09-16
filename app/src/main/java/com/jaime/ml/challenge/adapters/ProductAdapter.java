package com.jaime.ml.challenge.adapters;

/*-----------------------------------------------*/
/*					Author                       */
/*				Jaime Vallejo                    */
/*                                               */
/*				Fecha Creacion                   */
/*				  14/09/2020                     */
/*                                               */
/*				Descripcion                      */
/*   Proyecto creado como un Challenge de ML     */
/*   como proceso de selección                   */
/*-----------------------------------------------*/

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.jaime.ml.challenge.R;
import com.jaime.ml.challenge.interfaces.OnItemClickListener;
import com.jaime.ml.challenge.models.ProductML;

import java.text.NumberFormat;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    private List<ProductML> listProducts;
    private Context context;
    private OnItemClickListener listener;

    public ProductAdapter(List<ProductML> listProducts, OnItemClickListener listener) {
        this.listProducts = listProducts;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent,
                false);
        this.context = parent.getContext();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final ProductML productML = listProducts.get(position);
        String titleProduct = "Sin Título";
        StringBuilder price = new StringBuilder("Sin Precio Disponible");

        holder.setListener(productML, holder.imgFoto, holder.tvNombre, listener);

        if (productML.getTitle() != null && !productML.getTitle().isEmpty())
            titleProduct = productML.getTitle();

        if (productML.getPrice() > 0) {
            price.delete(0, price.length());
            if (productML.getCurrencyId() != null && !productML.getCurrencyId().isEmpty())
                price.append(productML.getCurrencyId()).append(" ");
            NumberFormat ft = NumberFormat.getCurrencyInstance();
            price.append(ft.format(productML.getPrice()));
        }

        holder.tvNombre.setText(titleProduct);
        holder.tvSubTitle.setText(price);
        holder.tvOrden.setText(String.valueOf(position+1));

        if (productML.getThumbnail() != null){
            RequestOptions options = new RequestOptions()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .placeholder(R.drawable.ic_sentiment_satisfied);

            Glide.with(context)
                    .load(productML.getThumbnail())
                    .apply(options)
                    .into(holder.imgFoto);
        } else {
            holder.imgFoto.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_account_box));
        }
    }

    @Override
    public int getItemCount() {
        return this.listProducts.size();
    }

    public void setList(List<ProductML> list) {
        this.listProducts = list;
        notifyDataSetChanged();
    }

    public void remove(ProductML artista) {
        if (listProducts.contains(artista)){
            listProducts.remove(artista);
            notifyDataSetChanged();
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.imgFoto)
        CircleImageView imgFoto;
        @BindView(R.id.tvNombre)
        AppCompatTextView tvNombre;
        @BindView(R.id.tvSubTitle)
        AppCompatTextView tvSubTitle;
        @BindView(R.id.tvOrden)
        AppCompatTextView tvOrden;
        @BindView(R.id.containerMain)
        ConstraintLayout containerMain;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void setListener(final ProductML productML, View imgPhoto, View tvName,
                         final OnItemClickListener listener){
            containerMain.setOnClickListener(view -> //listener.onItemClick(artista));
                    listener.onItemClick(productML, imgPhoto, tvName));

        }
    }
}
