package com.zoo.zoodirectory;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.UI> {
    private List<Animal> animalList;
    private Context context;
    AlertDialog.Builder builder;

    public AnimalAdapter(List<Animal> animalList, Context context) {
        this.animalList = animalList;
        this.context = context;
        builder = new AlertDialog.Builder(context);
    }

    @NonNull
    @Override
    public UI onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context)
                .inflate(R.layout.animal_thumbnail, null);
        return new UI(v);
    }

    @Override
    public void onBindViewHolder(@NonNull UI holder, final int position) {
        final Animal animal = animalList.get(position);
        holder.animalImage.setImageResource(animal.getImage());
        holder.animalName.setText(animal.getName());
        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(position == animalList.size() - 1){
                    builder.setTitle("Zoo Directory");
                    builder.setMessage("This animal is very scary. Do you wish to proceed?");
                    builder.setCancelable(false);
                    builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            context.startActivity(new Intent(context, AnimalDetails.class)
                                    .putExtra("image", animal.getImage())
                                    .putExtra("name", animal.getName())
                                    .putExtra("desc", animal.getDescription()));
                        }
                    });
                    builder.create();
                    builder.show();

                }else{
                    context.startActivity(new Intent(context, AnimalDetails.class)
                    .putExtra("image", animal.getImage())
                    .putExtra("name", animal.getName())
                    .putExtra("desc", animal.getDescription()));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return animalList.size();
    }

    public class UI extends RecyclerView.ViewHolder {
        CardView card;
        ImageView animalImage;
        TextView animalName;

        public UI(@NonNull View itemView) {
            super(itemView);
            card = itemView.findViewById(R.id.card);
            animalImage = itemView.findViewById(R.id.animalImage);
            animalName = itemView.findViewById(R.id.animalName);
        }
    }
}
