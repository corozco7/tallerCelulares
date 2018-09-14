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
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                }
            }
        });
    }

    public void reporte3(){
        ArrayList<Celular> celulares;
        ArrayList<Celular> huawei;
        huawei = new ArrayList<>();
        int menor, i=0;
        celulares = Datos.obtener();
        while (celulares.size() >= i){
            if (celulares.get(i).getMarca() == getResources().getString(R.string.huawei)
                    && celulares.get(i).getColor() == getResources().getString(R.string.blanco)
                    && celulares.get(i).getSo() == getResources().getString(R.string.android)){
                huawei.add(celulares.get(i));
            }
        }
        if (huawei.isEmpty()){
            Toast.makeText(this,
                    getResources().getString(R.string.mensaje_reporte_tres),
                    Toast.LENGTH_SHORT).show();
        }
    }

    public void reporte4(){

    }

    public void reporte5(){

    }

}
