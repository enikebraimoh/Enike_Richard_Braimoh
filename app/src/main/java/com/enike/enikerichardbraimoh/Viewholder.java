package com.enike.enikerichardbraimoh;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


    public class  Viewholder extends RecyclerView.ViewHolder {

        TextView fullname;
        TextView email;
        TextView gender;
        TextView country;
        TextView jobtitle;
        TextView aboutcar;
        TextView bio;

        public Viewholder(@NonNull View itemView) {
            super(itemView);

             fullname = itemView.findViewById(R.id.fullname);
             email = itemView.findViewById(R.id.email);
            gender = itemView.findViewById(R.id.gender);
            country = itemView.findViewById(R.id.country);
            jobtitle = itemView.findViewById(R.id.jobtitle);
            bio = itemView.findViewById(R.id.bio);
            aboutcar = itemView.findViewById(R.id.aboutcar);

        }


    }
