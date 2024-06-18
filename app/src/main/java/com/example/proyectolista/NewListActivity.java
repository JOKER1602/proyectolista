package com.example.proyectolista;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class NewListActivity extends AppCompatActivity {

    private EditText editTextListName;
    private Button buttonCreateList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_list);

        editTextListName = findViewById(R.id.editTextListName);
        buttonCreateList = findViewById(R.id.buttonCreateList);

        buttonCreateList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String listName = editTextListName.getText().toString().trim();
                if (!listName.isEmpty()) {
                    Intent intent = new Intent(NewListActivity.this, ViewListActivity.class);
                    intent.putExtra("listName", listName);
                    startActivity(intent);
                    finish(); // Cerrar esta actividad después de iniciar ViewListActivity
                }
            }
        });
    }
}
