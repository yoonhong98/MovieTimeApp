package com.example.movietimeapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.List;

public class imageAdapter extends SliderViewAdapter<imageAdapter.imageAdapterVH> {

    private Context context;
    private List<ImageSliderModel> SliderItems;

    public imageAdapter(Context context, List<ImageSliderModel> sliderItems) {
        this.context = context;
        this.SliderItems = sliderItems;
    }

    @Override
    public imageAdapterVH onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_layout, parent, false);
        return new imageAdapterVH(view);
    }

    @Override
    public void onBindViewHolder(imageAdapterVH viewHolder, int position) {
        Glide.with(viewHolder.itemView)
                .load(SliderItems.get(position).getImgUrl())
                .into(viewHolder.imageView);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "position" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getCount() {
        return SliderItems.size();
    }

    class imageAdapterVH extends SliderViewAdapter.ViewHolder{

        View itemView;
        ImageView imageView;

        public imageAdapterVH(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageSliderIV);
            this.itemView = itemView;
        }
    }
}