package com.example.movietimeapp;

import android.content.Context;
import android.transition.Slide;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.smarteist.autoimageslider.SliderView;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

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