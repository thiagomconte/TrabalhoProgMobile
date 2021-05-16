package com.example.trabalho;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

public class EditAluno extends AppCompatActivity {

    private EditText edtNome;
    private Spinner cursoSpinner;
    private EditText edtCPF;
    private EditText edtEmail;
    private EditText edtTelefone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_aluno);
        edtNome = findViewById(R.id.edtNomeCurso);
        edtCPF = findViewById(R.id.edtCPFAluno);
        edtEmail = findViewById(R.id.edtEmail);
        edtTelefone = findViewById(R.id.editUpdateTelefone);
        cursoSpinner = findViewById(R.id.spinnerAluno);
    }

    //TODO: atualizar aluno no banco de dados
    public void atualizarAluno(View view){

    }

    //TODO: deletar aluno do banco de dados
    public void deletarAluno(View view){

    }
}