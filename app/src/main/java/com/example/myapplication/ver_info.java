package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Set;

public class ver_info extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_info);
        Button resumen = findViewById(R.id.resumen);
        resumen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener datos guardados y mostrar resumen
                showSummary();
            }
        });
    }
    private void showSummary() {
        // Obtener datos guardados
        String nombreCognoms = SettingsActivity.getPreferencesString(this, "nom_cognoms", "");
        Set<String> razasSeleccionadas = SettingsActivity.getPreferencesSet(this, "razas_seleccionadas");
        boolean notificacionActivada = SettingsActivity.getPreferencesBoolean(this, "notificacion_activada", false);
        String peliculaSeleccionada = SettingsActivity.getPreferencesString(this, "pelicula_seleccionada", "");

        // Mostrar resumen
        TextView txtResumen = findViewById(R.id.txt_resumen);
        String resumen = "Nombre y Apellidos: " + nombreCognoms + "\n" +
                "Razas Seleccionadas: " + TextUtils.join(", ", razasSeleccionadas) + "\n" +
                "Notificación Activada: " + notificacionActivada + "\n" +
                "Película Seleccionada: " + peliculaSeleccionada;
        txtResumen.setText(resumen);

    }
}