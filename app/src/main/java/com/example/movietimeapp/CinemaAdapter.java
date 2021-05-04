package com.example.movietimeapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CinemaAdapter extends ArrayAdapter {
    final Context context;
    final Integer photo[];
    private final String cinema_name[];
    private final String cinema_hall[];

    public CinemaAdapter(@NonNull Context context, Integer photo[], String cinema_name[], String cinema_hall[]) {
        super(context, R.layout.cinema_layout, cinema_name);
        this.context = context;
        this.photo = photo;
        this.cinema_name = cinema_name;
        this.cinema_hall = cinema_hall;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.cinema_layout, null, true);

        TextView cinemaName = rowView.findViewById(R.id.cinemaName);
        TextView cinemaInfo = rowView.findViewById(R.id.hallInfo);
        ImageView cinemaPhoto = rowView.findViewById(R.id.imageView);
        Button forwardButton = rowView.findViewById(R.id.forward_btn);

        cinemaName.setText(cinema_name[position]);
        cinemaInfo.setText(cinema_hall[position]);
        cinemaPhoto.setImageResource(photo[position]);

        forwardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cName = (String) cinemaName.getText();

                switch (cName){
                    case "TGV KUANTAN":
                        context.startActivity(new Intent(getContext(), Cinema_movie.class));
                }
            }
        });

        return rowView;
    }
}
