package com.example.a38_nguyenbavan_lap4;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Spinner;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CreateNewNote extends AppCompatActivity {
    Spinner spType;
    ArrayList<String> groupType;
Button btnTune;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_note);
        spType = findViewById(R.id.spType);
        btnTune =findViewById(R.id.btnTune);
        groupType = new ArrayList<>();
        groupType.add("Word");
        groupType.add("Friend");
        groupType.add("Family");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getBaseContext(),
                android.R.layout.simple_list_item_1, groupType);
        spType.setAdapter(arrayAdapter);
        btnTune.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(getBaseContext(), view);
                popupMenu.getMenuInflater().inflate(R.menu.tune_menu,
                        popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.mnItemfile:
                                Toast.makeText(getBaseContext(), "FILE", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.mnItemdefaults:
                                Toast.makeText(getBaseContext(), "DEFAULTS", Toast.LENGTH_SHORT).show();
                                break;
                        }
                        return false;
                    }
                });

                popupMenu.show();
            }
        });
    }
}
