package com.example.movietimeapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CinemaMovieAdapter extends ArrayAdapter {
    final Context context;
    private final Integer movie_Image[];
    private final String movie_Name[];

    public CinemaMovieAdapter(@NonNull Context context, Integer[] movie_Image, String[] movie_Name) {
        super(context, R.layout.c_movie_layout, movie_Name);
        this.context = context;
        this.movie_Image = movie_Image;
        this.movie_Name = movie_Name;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.c_movie_layout, null, true);

        ImageView movieImage = rowView.findViewById(R.id.imageView1);
        TextView movieName = rowView.findViewById(R.id.textView1);

        movieImage.setImageResource(movie_Image[position]);
        movieName.setText(movie_Name[position]);

        return rowView;
    }
}
