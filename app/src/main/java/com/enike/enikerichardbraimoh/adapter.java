package com.enike.enikerichardbraimoh;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class adapter extends RecyclerView.Adapter<Viewholder>  {
    MainActivity mMainActivity; List<String> first_name,last_name,email,acountry,car_model,car_model_year,car_color,agender,job_title,bio;

    public adapter( MainActivity mainActivity, List<String> first_name, List<String> last_name, List<String> email, List<String> acountry, List<String> car_model, List<String> car_model_year, List<String> car_color, List<String> agender, List<String> job_title, List<String> bio) {
        mMainActivity = mainActivity;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.acountry = acountry;
        this.car_model = car_model;
        this.car_model_year = car_model_year;
        this.car_color = car_color;
        this.agender = agender;
        this.job_title = job_title;
        this.bio = bio;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(mMainActivity.getBaseContext());
        View view = layoutInflater.inflate(R.layout.items,parent,false);

        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final Viewholder holder, final int position) {
        holder.fullname.setText((first_name.get(position))+" "+(last_name.get(position)));
        holder.email.setText(this.email.get(position));
        holder.gender.setText(agender.get(position));
        holder.country.setText(acountry.get(position));
        holder.jobtitle.setText((job_title.get(position)));
        holder.bio.setText((bio.get(position)));
        holder.aboutcar.setText((car_color.get(position))+", "+(car_model.get(position))+", "+(car_model_year.get(position)));



    }

    @Override
    public int getItemCount() {
        return first_name.size();
    }

}