package com.jaime.ml.challenge.activities;

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

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.gson.Gson;
import com.jaime.ml.challenge.R;
import com.jaime.ml.challenge.models.Attribute;
import com.jaime.ml.challenge.models.ProductML;

import java.text.NumberFormat;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class DetalleActivity extends AppCompatActivity {

    //Variables del content_detalle
    //para el seteo de los valores
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.toolbar_layout)
    CollapsingToolbarLayout toolbarLayout;
    @BindView(R.id.app_bar)
    AppBarLayout appBar;
    @BindView(R.id.tvName)
    TextView tvName;
    @BindView(R.id.tvPriceOriginal)
    TextView tvPriceOriginal;
    @BindView(R.id.tvPrice)
    TextView tvPrice;
    @BindView(R.id.tvStock)
    TextView tvStock;
    @BindView(R.id.tvAddress)
    TextView tvAddress;
    @BindView(R.id.tvAttributes)
    TextView tvAttributes;
    @BindView(R.id.imgCover)
    AppCompatImageView imgCover;
    @BindView(R.id.imgFoto)
    CircleImageView imgFoto;

    //variable encargadade controlar el val
    private ProductML productML;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);
        ButterKnife.bind(this);

        configProduct(getIntent());
        configActionBar();
        configImageView(productML.getThumbnail());
    }

    //metodo encargado de setear los valores al layaout
    @SuppressLint("SetTextI18n")
    private void configProduct(Intent intent) {
        String titleProduct = "Sin Título";
        StringBuilder price = new StringBuilder("Sin Precio Disponible");
        String stock = "Sin Stock Disponible";
        StringBuilder address = new StringBuilder("Sin Ubicación Disponible");
        StringBuilder attributes = new StringBuilder("Sin Atributos");
        Gson gson = new Gson();

        try {
            productML = gson.fromJson(intent.getStringExtra(ProductML.ID),ProductML.class);

            if (productML.getTitle() != null && !productML.getTitle().isEmpty())
                titleProduct = productML.getTitle();

            if (productML.getPrice() > 0) {
                price.delete(0, price.length());
                if (productML.getCurrencyId() != null && !productML.getCurrencyId().isEmpty())
                    price.append(productML.getCurrencyId()).append(" ");
                NumberFormat ft = NumberFormat.getCurrencyInstance();
                price.append(ft.format(productML.getPrice()));
            }

            if (productML.getOriginalPrice() > 0) {
                NumberFormat ft = NumberFormat.getCurrencyInstance();
                tvPriceOriginal.setText(ft.format(productML.getOriginalPrice()));
                tvPriceOriginal.setPaintFlags(tvPriceOriginal.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            } else {
                tvPriceOriginal.setVisibility(View.INVISIBLE);
            }

            if (productML.getSoldQuantity() > 0) {
                stock = "Stock Disponible";
            }

            if (productML.getAddress() != null && (
                    (productML.getAddress().getStateName() != null
                            && !productML.getAddress().getStateName().isEmpty())
                    || (productML.getAddress().getCityName() != null
                            && !productML.getAddress().getCityName().isEmpty())
                    )) {
                address.delete(0, address.length());
                if (productML.getAddress().getStateName() != null
                        && !productML.getAddress().getStateName().isEmpty()){
                    address.append(productML.getAddress().getStateName()).append(" - ");
                }
                if (productML.getAddress().getCityName() != null
                        && !productML.getAddress().getCityName().isEmpty()) {
                    address.append(productML.getAddress().getCityName());
                }
            }

            if (productML.getAttributes() != null && productML.getAttributes().size() > 0) {
                attributes.delete(0, attributes.length());
                for (Attribute iterAttribute : productML.getAttributes()) {
                    if (iterAttribute.getName() != null
                            && !iterAttribute.getName().isEmpty()
                            && iterAttribute.getValueName() != null
                            && !iterAttribute.getValueName().isEmpty()) {
                        attributes.append(iterAttribute.getName())
                                  .append(": ")
                                  .append(iterAttribute.getValueName())
                                  .append(".\n");
                    }
                }
            }
        } catch (Exception e) {
            Log.e("ERROR_PRODUCT_DETAIL",e.toString());
            productML = new ProductML();
        } finally {
            tvName.setText(titleProduct);
            tvPrice.setText(price);
            tvStock.setText(stock);
            tvAddress.setText(address);
            tvAttributes.setText(attributes);
        }
    }

    //configuracion del appBar y activando opcion regresar
    private void configActionBar() {
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        toolbarLayout.setExpandedTitleColor(Color.WHITE);
    }

    //se carga la imagen con la url contenida en el objeto
    private void configImageView(String fotoUrl) {
        if (fotoUrl != null) {
            RequestOptions options = new RequestOptions()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .centerCrop();

            Glide.with(this)
                    .load(fotoUrl)
                    .apply(options)
                    .into(imgCover);
        } else {
            imgCover.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_photo_size_select_actual));
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                super.onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
