package com.example.trabalho;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.trabalho.dataBase.DBHelper;

public class RegistrarCurso extends AppCompatActivity {

    private DBHelper dbHelper = new DBHelper(this);
    private EditText edtNome;
    private EditText edtHoras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_curso);

        edtNome = findViewById(R.id.edtNomeCurso);
        edtHoras = findViewById(R.id.edtHorasCurso);
    }

    //TODO: salvar curso no banco de dados
    public void registrarCurso(View view){

    }
}