package com.example.trabalho;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.trabalho.dataBase.DBHelper;

public class MainActivity extends AppCompatActivity {
    private DBHelper helper = new DBHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void TrocarRegCurso (View view){
        Intent it=new Intent(this, RegistrarCurso.class);
        startActivity(it);
    }

    public void TrocarRegAluno (View view){
        Intent it=new Intent(this, RegistrarAluno.class);
        startActivity(it);
    }

    public void TrocarListarAlunos (View view){
        Intent it=new Intent(this, ListarAlunos.class);
        startActivity(it);
    }

    public void TrocarListarCursos(View view){
        Intent it=new Intent(this, ListarCursos.class);
        startActivity(it);
    }

}