package com.electiva3.proyecto_android_electiva3;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class activity_nuevo_user_reserva extends AppCompatActivity {

    private TextView txtUser, txtContrato, txtPlan, txtVehiculo, txtFechaA;
    private EditText txtHora, txtAprobacion;
    private Spinner spnContrato, spnPlan, spnVehiculo;
    private Button btnNuevo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user_reserva);

        txtUser = findViewById(R.id.txtTitulo);
        txtContrato = findViewById(R.id.txtContrato);
        txtPlan = findViewById(R.id.txtPlanreserva);
        txtVehiculo = findViewById(R.id.txtVehiculo);
        txtFechaA = findViewById(R.id.etPlannedDate);
        txtHora = findViewById(R.id.txtHora);
        spnContrato = findViewById(R.id.spnContrato);
        spnPlan = findViewById(R.id.spnPlan);
        spnVehiculo = findViewById(R.id.spnVehiculo);
        btnNuevo = findViewById(R.id.btnNuevo);
    }
}
