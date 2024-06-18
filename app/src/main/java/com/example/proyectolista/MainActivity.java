package com.example.proyectolista;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button buttonViewList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonViewList = findViewById(R.id.buttonViewList);
        buttonViewList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Aquí pasamos el nombre de la lista como ejemplo
                String listName = "Mi Lista de Compras"; // Cambiar según tu lógica para obtener el nombre
                Intent intent = new Intent(MainActivity.this, ViewListActivity.class);
                intent.putExtra("listName", listName);
                startActivity(intent);
            }
        });
    }
}
