package com.zoo.zoodirectory;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.button.MaterialButton;

public class ZooInformation extends AppCompatActivity {
    private MaterialButton dialBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zoo_information);

        dialBtn = findViewById(R.id.dialBtn);
        
        dialBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tel = "tel:888-8888";
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(tel));
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.zoo_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
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