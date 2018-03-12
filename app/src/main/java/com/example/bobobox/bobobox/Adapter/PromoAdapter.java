package com.example.bobobox.bobobox.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bobobox.bobobox.Data.PromoApi;
import com.example.bobobox.bobobox.R;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by Unknown on 3/11/2018.
 */

public class PromoAdapter extends RecyclerView.Adapter<PromoAdapter.ViewHolder> {

    int[] images = {R.drawable.slide1, R.drawable.slide2, R.drawable.slide3};
    Context context;
    List<PromoApi> promos;

    public PromoAdapter(Context context, List<PromoApi> promos) {
        this.context = context;
        this.promos = promos;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.promo_item, null);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        PromoApi promo = promos.get(position);
        DecimalFormat money = new DecimalFormat("#,###,###");

        holder.promoRoomName.setText(promo.getRoomName());
        holder.promoPercent.setText(promo.getPercent());
        holder.promoCity.setText(promo.getCity());
        holder.promoDiscount.setText("Rp. "+money.format(Double.parseDouble(promo.getOldPrice())).replaceAll(",","."));
        holder.promoDiscount.setPaintFlags(holder.promoDiscount.getPaintFlags()| Paint.STRIKE_THRU_TEXT_FLAG);
        holder.promoPrice.setText("Rp. "+money.format(Double.parseDouble(promo.getNewPrice())).replaceAll(",","."));
        holder.promoImage.setImageBitmap(roundedImage(images[position]));
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView promoImage;
        private TextView promoPercent, promoRoomName, promoCity, promoDiscount, promoPrice;
        public ViewHolder(View itemView) {
            super(itemView);
            promoImage = (ImageView) itemView.findViewById(R.id.boboboxImagePromoIV);
            promoPercent = (TextView) itemView.findViewById(R.id.boboboxSpecialPromoPercentTV);
            promoRoomName = (TextView) itemView.findViewById(R.id.boboboxSpecialPromoNameTV);
            promoCity = (TextView) itemView.findViewById(R.id.boboboxSpecialPromoCityTV);
            promoDiscount = (TextView) itemView.findViewById(R.id.boboboxOldPricePromoTV);
            promoPrice = (TextView) itemView.findViewById(R.id.boboboxNewPricePromoTV);
        }
    }

    private Bitmap roundedImage(int imagesR){
        Bitmap mbitmap = ((BitmapDrawable) context.getResources().getDrawable(imagesR)).getBitmap();
        Bitmap imageRounded = Bitmap.createBitmap(mbitmap.getWidth(), mbitmap.getHeight(), mbitmap.getConfig());
        Canvas canvas = new Canvas(imageRounded);
        Paint mpaint = new Paint();
        mpaint.setAntiAlias(true);
        mpaint.setShader(new BitmapShader(mbitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
        canvas.drawRoundRect((new RectF(0, 0, mbitmap.getWidth(), mbitmap.getHeight())), 20, 20, mpaint);// Round Image Corner 100 100 100 100
        return imageRounded;
    }
}
