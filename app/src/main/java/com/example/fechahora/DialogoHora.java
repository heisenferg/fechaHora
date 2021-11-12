package com.example.fechahora;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.KeyboardShortcutGroup;
import android.view.Menu;
import android.widget.TimePicker;

import androidx.annotation.Nullable;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class DialogoHora extends DialogFragment implements TimePickerDialog.OnTimeSetListener {

    OnHoraSeleccionada h;

    @Override
    public void onAttach(Activity activity) {
        h = (OnHoraSeleccionada) activity;
        super.onAttach(activity);
    }

    @Override
    public Dialog onCreateDialog (Bundle savedInstanceState){
        Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR);
        int minutes = c.get(Calendar.MINUTE);
        return new TimePickerDialog(getActivity(), this, hour, minutes, true);
    }

    @Override
    public void onTimeSet(TimePicker timePicker, int i, int i2){
        GregorianCalendar g = new GregorianCalendar();
        g.set(Calendar.HOUR, i);
        g.set(Calendar.MINUTE, i2);
        h.onResultadoHora(g);

    }


    public interface OnHoraSeleccionada{
        public void onResultadoHora(GregorianCalendar hora);
    }
}

