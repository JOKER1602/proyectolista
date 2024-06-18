package com.example.proyectolista;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ViewListActivity extends AppCompatActivity {

    private TextView textViewListName;
    private ListView listViewItems;
    private Button buttonAddItem;
    private Button buttonGoBack;
    private Button buttonNewList;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_list);

        // Obtener referencias de los elementos de la interfaz
        textViewListName = findViewById(R.id.textViewListName);
        listViewItems = findViewById(R.id.listViewItems);
        buttonAddItem = findViewById(R.id.buttonAddItem);
        buttonGoBack = findViewById(R.id.buttonGoBack);
        buttonNewList = findViewById(R.id.buttonNewList);

        // Configurar el ListView y el adaptador para mostrar los artículos de la lista
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ShoppingListManager.getShoppingItems());
        listViewItems.setAdapter(adapter);

        // Obtener el nombre de la lista desde MainActivity
        String listName = getIntent().getStringExtra("listName");
        textViewListName.setText(listName);

        // Escuchar click en el botón para agregar artículo
        buttonAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewListActivity.this, AddItemActivity.class);
                startActivityForResult(intent, 1);
            }
        });

        // Escuchar click en el botón "Regresar"
        buttonGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Cerrar la actividad actual y regresar a la actividad anterior (MainActivity)
            }
        });

        // Escuchar click en el botón "Nueva Lista"
        buttonNewList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Limpiar los artículos de la lista
                ShoppingListManager.clearShoppingItems();
                adapter.notifyDataSetChanged(); // Notificar al adaptador que los datos han cambiado
                Toast.makeText(ViewListActivity.this, "Se ha creado una nueva lista", Toast.LENGTH_SHORT).show();
            }
        });

        // Escuchar click en un artículo para marcar como comprado (aquí puedes implementar la lógica)
        listViewItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = ShoppingListManager.getShoppingItems().get(position);
                Toast.makeText(ViewListActivity.this, "Artículo marcado como comprado: " + selectedItem, Toast.LENGTH_SHORT).show();
                // Aquí puedes implementar la lógica para marcar el artículo como comprado
            }
        });
    }

    // Método para manejar el resultado de AddItemActivity al agregar un artículo
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
            String itemName = data.getStringExtra("itemName");
            String itemQuantity = data.getStringExtra("itemQuantity");
            String itemPrice = data.getStringExtra("itemPrice");

            String itemDetails = "Nombre: " + itemName + ", Cantidad: " + itemQuantity + ", Precio: " + itemPrice;

            // Agregar el artículo a la lista estática usando ShoppingListManager
            ShoppingListManager.addShoppingItem(itemDetails);

            // Notificar al adaptador que se añadió un nuevo artículo
            adapter.notifyDataSetChanged();
        }
    }
}
