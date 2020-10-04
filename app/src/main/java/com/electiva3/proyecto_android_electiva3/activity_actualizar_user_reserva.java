package com.electiva3.proyecto_android_electiva3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class activity_actualizar_user_reserva extends AppCompatActivity {

        private TextView txtUser, txtContrato, txtPlan, txtVehiculo, txtFechaA;
        private EditText txtHora, txtAprobacion;
        private Spinner spnContrato, spnPlan, spnVehiculo;
        private Button btnModificar;

        @Override
        protected void onCreate(Bundle savedInstanceState)
        {
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
            btnModificar = findViewById(R.id.btnActualizar);
        }
}