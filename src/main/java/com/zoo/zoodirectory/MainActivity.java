package com.zoo.zoodirectory;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView animalList;
    private AnimalAdapter adapter;
    private List<Animal> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = new ArrayList<>();

        animalList = findViewById(R.id.animalList);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        animalList.setLayoutManager(manager);

        populateAnimalThumbnail();

    }

    private void populateAnimalThumbnail(){
        list.add(new Animal(R.drawable.deer, "Deer",
                "Deer are hoofed ruminant mammals forming the family Cervidae. The two main groups of deer are the Cervinae, including the muntjac, the elk, the red deer, the fallow deer, and the chital; and the Capreolinae, including the reindeer, the roe deer, the mule deer, and the moose."));
        list.add(new Animal(R.drawable.peacock, "Peafowl",
                "Peafowl is a common name for three bird species in the genera Pavo and Afropavo of the family Phasianidae, the pheasants and their allies. Male peafowl are referred to as peacocks, and female peafowl as peahens, though peafowl of either sex are often referred to colloquially as peacocks"));
        list.add(new Animal(R.drawable.rhinoceros, "Rhinoceros",
                "A rhinoceros, commonly abbreviated to rhino, is one of any five extant species of odd-toed ungulates in the family Rhinocerotidae, as well as any of the numerous extinct species therein. Two of the extant species are native to Africa, and three to Southern Asia."));
        list.add(new Animal(R.drawable.hummingbird, "hummingbird",
                "Hummingbirds are birds native to the Americas and constituting the biological family Trochilidae. They are the smallest of birds, most species measuring 7.5–13 cm in length. The smallest extant hummingbird species is the 5 cm bee hummingbird, which weighs less than 2.0 g."));
        list.add(new Animal(R.drawable.whiteleopard, "Snow Leopard",
                "The snow leopard, also known as the ounce, is a large cat native to the mountain ranges of Central and South Asia. It is listed as Vulnerable on the IUCN Red List because the global population is estimated to number less than 10,000 mature individuals and is expected to decline about 10% by 2040."));

        adapter = new AnimalAdapter(list, this);
        animalList.setAdapter(adapter);
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