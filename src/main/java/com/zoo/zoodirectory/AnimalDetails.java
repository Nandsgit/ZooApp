package com.zoo.zoodirectory;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class AnimalDetails extends AppCompatActivity {
    private ImageView animalImage;
    private TextView animalName;
    private TextView animalDesc;

    private int image;
    private String name;
    private String desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_details);

        Intent i = getIntent();
        if (i != null) {
            image = i.getIntExtra("image", R.drawable.deer);
            name = i.getStringExtra("name");
            desc = i.getStringExtra("desc");
        }

        animalImage = findViewById(R.id.animalImage);
        animalName = findViewById(R.id.animalName);
        animalDesc = findViewById(R.id.animalDesc);

        animalImage.setImageResource(image);
        animalName.setText(name);
        animalDesc.setText(desc);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.zoo_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.information:
                startActivity(new Intent(this, ZooInformation.class));
                return true;
            case R.id.uninstall:
                Intent intent = new Intent(Intent.ACTION_DELETE);
                intent.setData(Uri.parse("package:com.zoo.zoodirectory"));
                startActivity(intent);
                return true;

        }
        return super.onOptionsItemSelected(item);
    }
}