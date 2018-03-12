package com.example.bobobox.bobobox.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.bobobox.bobobox.Data.BoboboxList;
import com.example.bobobox.bobobox.UI.DetailRoom;
import com.example.bobobox.bobobox.R;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by ganteun unikom eka on 12/29/2017.
 */

public class BoboboxAdapter extends RecyclerView.Adapter<BoboboxAdapter.ViewHolder> {

    private List<BoboboxList> boboboxLists;
    private Context context;

    public BoboboxAdapter(List<BoboboxList> boboboxLists, Context context) {
        this.boboboxLists = boboboxLists;
        this.context = context;
    }

    @Override
    public BoboboxAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_bobobox_room_layout, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(BoboboxAdapter.ViewHolder holder, int position) {
        final BoboboxList boboboxList = boboboxLists.get(position);
        DecimalFormat money = new DecimalFormat("#,###,###");

//        loadImageUrl("http://192.168.0.100/"+boboboxList.getImage(), holder.boboboxImage);
        holder.boboboxName.setText(boboboxList.getNamaHotel());
        holder.boboboxPrice.setText("Rp. "+money.format(boboboxList.getHarga()).replace(",","."));
        holder.boboboxAddress.setText(boboboxList.getAlamat()+", Ina");
        holder.boboboxRating.setRating(Float.parseFloat(boboboxList.getRating().toString()));
        holder.boboboxImage.setImageBitmap(roundedImage(R.drawable.slide2));
        holder.boboboxId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //put id in intent extra
                Intent intent = new Intent(context, DetailRoom.class);
                intent.putExtra("id_hotel", boboboxList.getId());
                context.startActivity(intent);
            }
        });
        if(boboboxList.getPosition().toLowerCase().equals("sky"))
            holder.boboboxType.setImageResource(R.drawable.ic_room_type1);

        if(boboboxList.getPosition().toLowerCase().equals("earth"))
            holder.boboboxType.setImageResource(R.drawable.ic_room_type2);
    }

    @Override
    public int getItemCount() {
        return boboboxLists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView boboboxName;
        public TextView boboboxPrice;
        public TextView boboboxAddress;
        public RatingBar boboboxRating;
        public TextView boboboxDistance;
        public ImageView boboboxImage;
        public TextView boboboxContryCode;
        public ImageView boboboxType;
        public CardView boboboxId;

        public ViewHolder(View itemView) {
            super(itemView);
            boboboxName = (TextView) itemView.findViewById(R.id.boboboxNameRoom);
            boboboxPrice = (TextView) itemView.findViewById(R.id.boboboxPriceRoom);
            boboboxAddress = (TextView) itemView.findViewById(R.id.boboboxAddressRoom);
            boboboxRating = (RatingBar) itemView.findViewById(R.id.boboboxRatingRoom);
            boboboxDistance = (TextView) itemView.findViewById(R.id.boboboxDistanceRoom);
            boboboxType = (ImageView) itemView.findViewById(R.id.boboboxTypeRoom);
            boboboxId = (CardView) itemView.findViewById(R.id.boboboxIdRoom);
            boboboxImage = (ImageView) itemView.findViewById(R.id.boboboxImageRoom);
//            boboboxName = (TextView) itemView.findViewById(R.id.boboboxCountryCodeRoom);
        }
    }

    private Bitmap roundedImage(int imageR){
        Bitmap mbitmap = ((BitmapDrawable) context.getResources().getDrawable(imageR)).getBitmap();
        Bitmap imageRounded = Bitmap.createBitmap(mbitmap.getWidth(), mbitmap.getHeight(), mbitmap.getConfig());
        Canvas canvas = new Canvas(imageRounded);
        Paint mpaint = new Paint();
        mpaint.setAntiAlias(true);
        mpaint.setShader(new BitmapShader(mbitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
        canvas.drawRoundRect((new RectF(0, 0, mbitmap.getWidth(), mbitmap.getHeight())), 20, 20, mpaint);// Round Image Corner 100 100 100 100
        return imageRounded;
    }

    private void loadImageUrl(String url, ImageView boboboxImage){
        Picasso.with(context).load(url).placeholder(R.drawable.view_main)
                .error(R.drawable.view_main)
                .into(boboboxImage);
    }
}
