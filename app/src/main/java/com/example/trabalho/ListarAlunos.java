package com.example.trabalho;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.trabalho.dataBase.DBHelper;

public class ListarAlunos extends AppCompatActivity {

    private DBHelper dbHelper = new DBHelper(this);
    private ListView listAlunos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_alunos);

        listAlunos = findViewById(R.id.viewListaAlunos);
    }
}