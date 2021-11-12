package com.example.fechahora;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class MainActivity extends Activity implements DialogoFecha.OnFechaSeleccionada,DialogoHora.OnHoraSeleccionada {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

/*
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }*/

    public void onClickFecha(View view) {
        DialogoFecha d=new DialogoFecha();
        d.show(getFragmentManager(),"Mi diálogo Fecha");
    }
    public void onClickHora(View view){
        DialogoHora d=new DialogoHora();
        d.show(getFragmentManager(),"Mi diálogo Hora");

    }
    @Override
    public void onResultadoFecha(GregorianCalendar fecha) {
        EditText et=(EditText)findViewById(R.id.etFechaNacimiento);
        et.setText(fecha.get(Calendar.DAY_OF_MONTH)+"/"+(fecha.get(Calendar.MONTH)+1)+"/"+fecha.get(Calendar.YEAR));
    }


    @Override
    public void onResultadoHora(GregorianCalendar hora) {
        EditText et=(EditText)findViewById(R.id.etHora);
        et.setText(hora.get(Calendar.HOUR)+":"+hora.get(Calendar.MINUTE));
    }
}

