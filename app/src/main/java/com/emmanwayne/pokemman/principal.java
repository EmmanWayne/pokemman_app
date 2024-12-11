package com.emmanwayne.pokemman;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class principal extends AppCompatActivity {
    Button btnPokedex, btnSalir, btnAcercaDe;
    int id = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        btnPokedex = findViewById(R.id.btnPokedex);
        btnSalir = findViewById(R.id.btnSalir);
        btnAcercaDe = findViewById(R.id.btnAcercaDe);

        btnAcercaDe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirAcercaDe();
            }
        });


        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Salir();
            }
        });


    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {

            new AlertDialog.Builder(this)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle("¿Deseas salir?")
                    .setMessage("¿Estás seguro?")
                    .setNegativeButton("No", null)// sin listener
                    .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            principal.this.finish();
                        }
                    })
                    .show();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void abrirAcercaDe() {
        Intent intent = new Intent(this, acerca_de.class);
        intent.putExtra("ID", id);
        startActivity(intent);
    }


    private void Salir() {
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("¿Deseas salir?")
                .setMessage("¿Estás seguro?")
                .setNegativeButton("No", null)// sin listener
                .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        principal.this.finish();
                    }
                })
                .show();
    }
}