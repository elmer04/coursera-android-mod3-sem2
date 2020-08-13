package com.elmer.mod3sem2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText etNombre;
    private TextInputEditText etFechaNac;
    private TextInputEditText etTelefono;
    private TextInputEditText etEmail;
    private TextInputEditText etDescripcion;

    MaterialDatePicker<Long> materialDatePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNombre = findViewById(R.id.etNombre);
        etFechaNac = findViewById(R.id.etFechaNac);
        etTelefono = findViewById(R.id.etTelefono);
        etEmail = findViewById(R.id.etEmail);
        etDescripcion = findViewById(R.id.etDescripcion);

        materialDatePicker = MaterialDatePicker.Builder.datePicker()
                .setTitleText(getResources().getString(R.string.date))
                .build();

        materialDatePicker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener<Long>() {
            @Override
            public void onPositiveButtonClick(Long selection) {
                etFechaNac.setText(materialDatePicker.getHeaderText());
            }
        });

        etFechaNac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                materialDatePicker.show(getSupportFragmentManager(), "DATE_PICKER");
            }
        });
    }

    public void siguiente(View view) {
        Intent intent= new Intent(MainActivity.this, ConfirmarDatos.class);
        intent.putExtra(getResources().getString(R.string.NOMBRE), etNombre.getText().toString());
        intent.putExtra(getResources().getString(R.string.FECHANAC), etFechaNac.getText().toString());
        intent.putExtra(getResources().getString(R.string.TELEF), etTelefono.getText().toString());
        intent.putExtra(getResources().getString(R.string.EMAIL), etEmail.getText().toString());
        intent.putExtra(getResources().getString(R.string.DESC), etDescripcion.getText().toString());
        startActivity(intent);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if ( v instanceof EditText) {
                Rect outRect = new Rect();
                v.getGlobalVisibleRect(outRect);
                if (!outRect.contains((int)event.getRawX(), (int)event.getRawY())) {
                    v.clearFocus();
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
            }
        }
        return super.dispatchTouchEvent( event );
    }
}