package com.example.proyectolista;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AddItemActivity extends AppCompatActivity {

    private EditText editTextItemName, editTextItemQuantity, editTextItemPrice;
    private Button buttonSaveItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        editTextItemName = findViewById(R.id.editTextItemName);
        editTextItemQuantity = findViewById(R.id.editTextItemQuantity);
        editTextItemPrice = findViewById(R.id.editTextItemPrice);
        buttonSaveItem = findViewById(R.id.buttonSaveItem);

        buttonSaveItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("itemName", editTextItemName.getText().toString());
                resultIntent.putExtra("itemQuantity", editTextItemQuantity.getText().toString());
                resultIntent.putExtra("itemPrice", editTextItemPrice.getText().toString());
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }
}
