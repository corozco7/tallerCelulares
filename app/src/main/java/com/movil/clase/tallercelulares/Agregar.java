package com.movil.clase.tallercelulares;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Agregar extends AppCompatActivity {

    private EditText precio;
    private Spinner marca, color, so;
    private Resources recursos;
    private String ma[], co[], sop[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);

        precio = findViewById(R.id.txtPrecio);
        marca = findViewById(R.id.cmbMarca);
        color = findViewById(R.id.cmbColor);
        so = findViewById(R.id.cmbSO);
        recursos = this.getResources();
        ma = recursos.getStringArray(R.array.marcas);
        co = recursos.getStringArray(R.array.colores);
        sop = recursos.getStringArray(R.array.so);
        ArrayAdapter<String> adapterMarcas = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item,ma);
        marca.setAdapter(adapterMarcas);
        ArrayAdapter<String> adapterColores = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item,co);
        color.setAdapter(adapterColores);
        ArrayAdapter<String> adapterSO = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item,sop);
        so.setAdapter(adapterSO);
    }

    private boolean validar(){
        if (precio.getText().toString().isEmpty()){
            precio.setError(recursos.getString(R.string.error_uno));
            precio.requestFocus();
            return  false;
        }
        int validar = Integer.parseInt(precio.getText().toString());
        if (validar <= 0){
            precio.setError(recursos.getString(R.string.error_dos));
            precio.requestFocus();
            return  false;
        }
        return true;
    }

    public void guardar(View v){
        if (validar()) {
            String mrc, col, sis;
            int prc;
            mrc = marca.getSelectedItem().toString();
            col = color.getSelectedItem().toString();
            sis = so.getSelectedItem().toString();
            prc = Integer.parseInt(precio.getText().toString());
            Celular c = new Celular(mrc, col, sis, prc);
            c.guardar();
            Toast.makeText(this,
                    getResources().getString(R.string.mensaje), Toast.LENGTH_SHORT).show();
            borrar();
        }
    }

    public void limpiar (View v){
        borrar();
    }

    private void borrar(){
        marca.setSelection(0);
        color.setSelection(0);
        so.setSelection(0);
        precio.setText("");
        precio.requestFocus();
    }
}
