package com.example.admin;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.core.Tag;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class add_item extends AppCompatActivity {

    Spinner spinner;

    EditText fruitName_insert, fruitPrice_insert;
    Button add;
    FirebaseFirestore dbroot = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setSelectedItemId(R.id.addItem);


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.orders:
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        overridePendingTransition(0, 0);
                        return true;


                    case R.id.addItem:
                        return true;

                    case R.id.stock:
                        startActivity(new Intent(getApplicationContext(), stocks.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });


        spinner = findViewById(R.id.spinner_unit);
        fruitName_insert = findViewById(R.id.fruitName_insert);
        fruitPrice_insert = findViewById(R.id.fruitPrice_insert);
        add = findViewById(R.id.btn_add);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.unit, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inserted();
            }

            public void inserted() {

                String unitDialoge;
                unitDialoge = spinner.getSelectedItem().toString();

                Map<String, String> itemAdd = new HashMap<>();
                itemAdd.put("fruitName", fruitName_insert.getText().toString().trim());
                itemAdd.put("fruitPrice", fruitPrice_insert.getText().toString().trim());
                itemAdd.put("fruitUnit", unitDialoge);
                itemAdd.put("unit", unitDialoge);

                dbroot.collection("fruits").add(itemAdd).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {


                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d(TAG, "DocumentSnapshotAdded with id : " + fruitName_insert);
                        fruitName_insert.setText("");
                        fruitPrice_insert.setText("");
                        Toast.makeText(getApplicationContext(), "Fruit inserted in stock successfully", Toast.LENGTH_SHORT).show();

                    }
                })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.w(TAG, "Error adding document", e);
                            }
                        });
            }
        });


    }
}