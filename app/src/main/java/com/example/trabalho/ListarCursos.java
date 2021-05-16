package com.example.trabalho;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.trabalho.dataBase.DBHelper;

public class ListarCursos extends AppCompatActivity {

    private DBHelper dbHelper = new DBHelper(this);
    private ListView listCursos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_cursos);

        listCursos = findViewById(R.id.viewListaCursos);
    }
}