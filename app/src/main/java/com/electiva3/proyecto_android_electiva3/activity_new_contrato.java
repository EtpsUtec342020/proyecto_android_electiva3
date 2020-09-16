package com.electiva3.proyecto_android_electiva3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class activity_new_contrato extends AppCompatActivity
{
    private TextView txtCliente;
    private ConstraintLayout vt2;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_contrato);

        txtCliente = findViewById(R.id.txtNombre);
        vt2 = findViewById(R.id.vt2);

        txtCliente.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
             //   vt2.setVisibility(View.VISIBLE);
            }
        });
    }
}
