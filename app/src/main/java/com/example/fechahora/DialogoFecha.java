package com.example.fechahora;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.DatePicker;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class DialogoFecha extends DialogFragment implements DatePickerDialog.OnDateSetListener {
   OnFechaSeleccionada f;

    @Override
   public void onAttach(Activity activity) {
        f=(OnFechaSeleccionada)activity;
        super.onAttach(activity);
    }
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        return new DatePickerDialog(getActivity(),this, year, month, day);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        GregorianCalendar calendario = new GregorianCalendar(year, month, dayOfMonth);
        f.onResultadoFecha(calendario);
    }

   public interface OnFechaSeleccionada{
       public void onResultadoFecha(GregorianCalendar fecha);
   }





}
