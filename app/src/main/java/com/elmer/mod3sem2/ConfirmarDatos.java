package com.elmer.mod3sem2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.textview.MaterialTextView;

public class ConfirmarDatos extends AppCompatActivity {

    private MaterialTextView tvNombre;
    private MaterialTextView tvFecha;
    private MaterialTextView tvTelefono;
    private MaterialTextView tvEmail;
    private MaterialTextView tvDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_datos);

        Bundle parametros = getIntent().getExtras();
        String nombre = parametros.getString(getResources().getString(R.string.NOMBRE));
        String fechaNac = parametros.getString(getResources().getString(R.string.FECHANAC));
        String telef = parametros.getString(getResources().getString(R.string.TELEF));
        String email = parametros.getString(getResources().getString(R.string.EMAIL));
        String desc = parametros.getString(getResources().getString(R.string.DESC));

        tvNombre = findViewById(R.id.tvNombre);
        tvFecha = findViewById(R.id.tvFecha);
        tvTelefono = findViewById(R.id.tvTelelefono);
        tvEmail = findViewById(R.id.tvEmail);
        tvDescripcion = findViewById(R.id.tvDescripcion);

        tvNombre.setText(nombre);
        tvFecha.setText(fechaNac);
        tvTelefono.setText(telef);
        tvEmail.setText(email);
        tvDescripcion.setText(desc);
    }

    public void editar(View view) {
        finish();
    }
}