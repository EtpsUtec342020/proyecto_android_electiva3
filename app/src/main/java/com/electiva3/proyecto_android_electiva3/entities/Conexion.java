package com.electiva3.proyecto_android_electiva3.entities;


import android.content.Context;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class Conexion
{
    FirebaseDatabase firabaseDataBase;
    DatabaseReference databaseReference;

    public FirebaseDatabase getFirabaseDataBase() {
        return firabaseDataBase;
    }

    public void setFirabaseDataBase(FirebaseDatabase firabaseDataBase) {
        this.firabaseDataBase = firabaseDataBase;
    }

    public DatabaseReference getDatabaseReference() {
        return databaseReference;
    }

    public void setDatabaseReference(DatabaseReference databaseReference) {
        this.databaseReference = databaseReference;
    }

    public void inicializarFirabase(Context context)
    {
        FirebaseApp.initializeApp(context);
        firabaseDataBase = FirebaseDatabase.getInstance();
        databaseReference = firabaseDataBase.getReference();
    }



}
