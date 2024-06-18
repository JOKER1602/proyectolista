package com.example.proyectolista;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class AddListActivity extends AppCompatActivity {

    private EditText editTextListName;
    private Button buttonAddList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_list);

        editTextListName = findViewById(R.id.editTextListName);
        buttonAddList = findViewById(R.id.buttonAddList);

        buttonAddList.setOnClickListener(v -> {
            String listName = editTextListName.getText().toString();
            Intent resultIntent = new Intent();
            resultIntent.putExtra("listName", listName);
            setResult(RESULT_OK, resultIntent);
            finish();
        });
    }
}
