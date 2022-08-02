package com.example.estudiantesnoche;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {


    EditText jetidentificacion, jetnombre, jetdireccion, jettelefono;
    Button jbtregistrar, jbtconsultar, jbtmodificar, jbteliminar, jbtlimpiar, jbtlistar;
        FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        getSupportActionBar().hide();

        jetidentificacion = findViewById(R.id. etidentificación);
        jetnombre = findViewById(R.id. etnombre);
        jetdireccion = findViewById(R.id. etdireccion);
        jettelefono = findViewById(R.id. ettelefono);
        jbtregistrar = findViewById(R.id. btregistrar);
        jbtconsultar = findViewById(R.id. btconsultar);
        jbtmodificar = findViewById(R.id. btmodificar);
        jbteliminar= findViewById(R.id. bteliminar);
        jbtlimpiar = findViewById(R.id. btlimpiar);
        jbtlistar = findViewById(R.id. btlistar);

        jbtregistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Adicionar_datos();
            }
        });

        jbtlimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Limpiar_datos();
            }
        });

    }

    public void Adicionar_datos() {
        String identificacion, nombre, direccion, telefono;

        identificacion = jetidentificacion.getText().toString();
        nombre = jetnombre.getText().toString();
        direccion = jetdireccion.getText().toString();
        telefono = jettelefono.getText().toString();

        if(identificacion.isEmpty() || nombre.isEmpty() || direccion.isEmpty() || telefono.isEmpty()){
            Toast.makeText(this, "Todos los datos son requeridos", Toast.LENGTH_SHORT).show();
            jetidentificacion.requestFocus();
        }else{
            // Create a new user with a first and last name
            Map<String, Object> estudiante = new HashMap<>();
            estudiante.put("Identificacion", identificacion);
            estudiante.put("Nombre", nombre);
            estudiante.put("Direccion", direccion);
            estudiante.put("Telefono", telefono
            );


// Add a new document with a generated ID
            db.collection("estudiante")
                    .add(estudiante)
                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                        @Override
                        public void onSuccess(DocumentReference documentReference) {
                           // Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                            Limpiar_datos();
                            Toast.makeText(MainActivity.this, "Datos guardados", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                          // Log.w(TAG, "Error adding document", e);
                            Toast.makeText(MainActivity.this, "Error guardando datos", Toast.LENGTH_SHORT).show();
                        }
                    });
        }

    }

    public void Limpiar_datos(){
        jettelefono.setText("");
        jetdireccion.setText("");
        jetnombre.setText("");
        jetidentificacion.setText("");
        jetidentificacion.requestFocus();
    }
}