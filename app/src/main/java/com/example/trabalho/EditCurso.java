package com.example.trabalho;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.trabalho.dataBase.DBHelper;

public class EditCurso extends AppCompatActivity {

    private DBHelper dbHelper = new DBHelper(this);
    private EditText edtNomeDoCurso;
    private EditText edtHoras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_curso);
        edtNomeDoCurso = findViewById(R.id.edtNomeCurso);
        edtHoras = findViewById(R.id.edtHorasCurso);
    }

    //TODO: atualizar curso no banco de dados
    public void atualizarCurso(View view){

    }

    //TODO: deletar curso do banco de dados
    public void deletarCurso(View view){

    }
}