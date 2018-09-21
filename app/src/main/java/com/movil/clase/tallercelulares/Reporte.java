package com.movil.clase.tallercelulares;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.widget.Toast.LENGTH_SHORT;

public class Reporte extends AppCompatActivity {

    private ListView lv;
    private String [] opc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reporte);

        lv = findViewById(R.id.lstReportes);
        opc = getResources().getStringArray(R.array.reportes);

        ArrayAdapter<String> adapter = new ArrayAdapter
                (this,android.R.layout.simple_list_item_1,opc);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        reporte3();
                        break;
                    case 1:
                        reporte4();
                        break;
                    case 2:
                        break;
                }
            }
        });
    }

    public void reporte3(){
        ArrayList<Celular> celulares;
        ArrayList<Celular> huawei = new ArrayList<>();
        int menor, i=0;
        String marca = "", color ="", so = "";
        celulares = Datos.obtener();
        if (celulares.isEmpty()) {
            Toast.makeText(this,
                    getResources().getString(R.string.no_agregados),
                    LENGTH_SHORT).show();
        } else {
            while (celulares.size() > i) {
                if (celulares.get(i).getMarca().equalsIgnoreCase(getResources().getString(R.string.huawei))
                        && celulares.get(i).getColor().equalsIgnoreCase(getResources().getString(R.string.blanco))
                        && celulares.get(i).getSo().equalsIgnoreCase(getResources().getString(R.string.android))) {
                    huawei.add(celulares.get(i));
                }
                i++;
            }
            if (huawei.isEmpty()) {
                Toast.makeText(this,
                        getResources().getString(R.string.mensaje_reporte_tres),
                        LENGTH_SHORT).show();
            } else {
                menor = huawei.get(0).getPrecio();
                for (int j = 0; j < huawei.size(); j++) {
                    if (huawei.get(j).getPrecio() <= menor) {
                        menor = huawei.get(j).getPrecio();
                        marca = huawei.get(j).getMarca();
                        color = huawei.get(j).getColor();
                        so = huawei.get(j).getSo();
                    }
                }
                Toast.makeText(this, getResources().getString(R.string.precio)
                        + ": " + menor + " " + getResources().getString(R.string.marca)
                        + ": " + marca + " " + getResources().getString(R.string.color)
                        + ": " + color + " " + getResources().getString(R.string.sistemaOperativo)
                        + ": " + so, LENGTH_SHORT).show();
            }
        }
    }

    public void reporte4(){
        ArrayList<Celular> celulares;
        ArrayList<Celular> apple = new ArrayList<>();
        int i = 0, cantidad = 0;
        celulares = Datos.obtener();
        if (celulares.isEmpty()) {
            Toast.makeText(this,
                    getResources().getString(R.string.no_agregados),
                    LENGTH_SHORT).show();
        } else {
            while (celulares.size() > i){
                if (celulares.get(i).getMarca().equalsIgnoreCase
                        (getResources().getString(R.string.apple))
                        && celulares.get(i).getColor().equalsIgnoreCase
                        (getResources().getString(R.string.negro))){
                    apple.add(celulares.get(i));
                }
                i++;
            }
            if (apple.isEmpty()){
                Toast.makeText(this,
                        getResources().getString(R.string.mensaje_reporte_cuatro),
                        LENGTH_SHORT).show();
            } else {
                while (apple.size() > cantidad){
                    cantidad++;
                }
                Toast.makeText(this,getString(R.string.cantidad) + ": " +
                        cantidad,LENGTH_SHORT).show();
            }
        }

    }

    public void reporte5(){

    }

}
