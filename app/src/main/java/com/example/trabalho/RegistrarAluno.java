package com.example.trabalho;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.trabalho.dataBase.DBHelper;
import com.example.trabalho.models.Aluno;

public class RegistrarAluno extends AppCompatActivity {

    private DBHelper dbHelper = new DBHelper(this);

    private EditText edtNome;
    private Spinner spinnerRegAluno;
    private int cursoId;
    private EditText edtCPF;
    private EditText edtEmail;
    private EditText edtTelefone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_aluno);

        edtNome = findViewById(R.id.edtNomeAluno);
        spinnerRegAluno = findViewById(R.id.spinnerRegAluno);
        edtCPF = findViewById(R.id.edtCPFAluno);
        edtEmail = findViewById(R.id.edtEmail);
        edtTelefone = findViewById(R.id.edtTelefone);
    }

    //TODO: salvar aluno no banco de dados
    public void registrarAluno(View view){
        Aluno aluno = new Aluno(this.cursoId, edtNome.getText().toString(), edtCPF.getText().toString(),
                edtEmail.getText().toString(), edtTelefone.getText().toString());
        dbHelper.inserirAluno(aluno);

    }
}