package com.example.trabalho.dataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.trabalho.models.Aluno;
import com.example.trabalho.models.Curso;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME="trabalho.db";
    private static final String TABLE_CURSO = "curso";
    private static final String TABLE_ALUNO = "aluno";

    SQLiteDatabase db;
    private static final String CREATE_TABLE_CURSO = "CREATE TABLE curso "+
            "(cursoId integer PRIMARY KEY autoincrement, nomeCurso text NOT NULL, qtdeHoras integer DEFAULT 0)";

    private static final String CREATE_TABLE_ALUNO = "CREATE TABLE aluno " +
            "(alunoId integer PRIMARY KEY AUTOINCREMENT, cursoId integer , " +
            "nomeAluno text NOT NULL, cpf text NOT NULL, email text NOT NULL, telefone text NOT NULL,"+
            "FOREIGN KEY(cursoId) REFERENCES curso(cursoId) )";

    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_CURSO);
        db.execSQL(CREATE_TABLE_ALUNO);
        this.db = db;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS "+TABLE_ALUNO;
        String query2 = "DROP TABLE IF EXISTS "+TABLE_CURSO;
        db.execSQL(query);
        db.execSQL(query2);
        this.onCreate(db);
    }

    /**
     *  -------------------- MÉTODOS DE CURSOS -------------------------
     */

    /**
     * INSERE CURSO
     */
    public void inserirCurso(Curso c){
        db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("nomeCurso", c.getNomeCurso());
        values.put("qtdeHoras", c.getQtdeHoras());
        db.insert(TABLE_CURSO,null,values);
        db.close();
    }

    /**
     * BUSCA TODOS OS CURSOS
     */
    public ArrayList<Curso> selectAllCursos(){
        String[] coluns = {"cursoId","nomeCurso","qtdeHoras"};
        Cursor cursor = getReadableDatabase().query(TABLE_CURSO,coluns,null,null,null,
                null,"upper(nomeCurso)",null);
        ArrayList<Curso> listaCursos = new ArrayList<Curso>();
        while(cursor.moveToNext()){
            Curso c = new Curso();
            c.setCursoId(cursor.getInt(0));
            c.setNomeCurso(cursor.getString(1));
            c.setQtdeHoras(cursor.getInt(2));
            listaCursos.add(c);
        }
        return listaCursos;
    }

    /**
     * ATUALIZA CURSO
     */
    public long updateCurso(Curso c){
        long retornoBD;
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("nomeCurso",c.getNomeCurso());
        values.put("qtdeHoras",c.getQtdeHoras());
        String[] args = {String.valueOf(c.getCursoId())};
        retornoBD=db.update(TABLE_CURSO,values,"cursoId=?",args);
        db.close();
        return retornoBD;
    }


    /**
     * DELETA CURSO SE NÃO HÁ ALUNO MATRICULADO
     */
    public boolean deleteCurso(Curso c){
        db = this.getWritableDatabase();

        if(!this.findAluno(c.getCursoId())){
            String[] args = {String.valueOf(c.getCursoId())};
            return db.delete(TABLE_CURSO, "cursoId=?",args) > 0;
        }

        return false;
    }

    /**
     *  -------------------- MÉTODOS DE ALUNOS -------------------------
     */

    /**
     * VERIFICA SE EXISTE ALUNO MATRICULADO NO CURSO
     */
    public boolean findAluno(int id){
        db=this.getReadableDatabase();
        String query = "select alunoId from "+TABLE_ALUNO+" where aluno.id = "+id;

        Cursor cursor=db.rawQuery(query,null);
        boolean encontrado = false;

        if(cursor != null){
            encontrado = true;
        }
        return encontrado;
    }

    /**
     * INSERE ALUNO
     */
    public void inserirAluno(Aluno a){
        db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("cursoId",a.getCursoId());
        values.put("nomeAluno", a.getNomeAluno());
        values.put("cpf", a.getCpf());
        values.put("email", a.getEmail());
        values.put("telefone", a.getTelefone());
        db.insert(TABLE_CURSO,null,values);
        db.close();
    }

    /**
     * BUSCA TODOS OS ALUNOS
     */
    public ArrayList<Aluno> selectAllAlunos(){
        String[] coluns = {"alunoId","cursoId","nomeAluno","cpf","email","telefone"};
        Cursor cursor = getReadableDatabase().query(TABLE_ALUNO,coluns,null,null,null,
                null,"upper(nomeAluno)",null);
        ArrayList<Aluno> listaAlunos = new ArrayList<Aluno>();
        while(cursor.moveToNext()){
            Aluno a = new Aluno();
            a.setAlunoId(cursor.getInt(0));
            a.setCursoId(cursor.getInt(1));
            a.setNomeAluno(cursor.getString(2));
            a.setCpf(cursor.getString(3));
            a.setEmail(cursor.getString(4));
            a.setTelefone(cursor.getString(5));
            listaAlunos.add(a);
        }
        return listaAlunos;
    }

    /**
     * ATUALIZA ALUNO
     */
    public long updateAluno(Aluno a){
        long retornoBD;
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("cursoId", a.getCursoId());
        values.put("nomeAluno",a.getNomeAluno());
        values.put("cpf",a.getCpf());
        values.put("email",a.getEmail());
        values.put("telefone",a.getTelefone());
        String[] args = {String.valueOf(a.getAlunoId())};
        retornoBD=db.update(TABLE_ALUNO,values,"alunoId=?",args);
        db.close();
        return retornoBD;
    }

    /**
     * DELETA ALUNO
     */
    public boolean deleteAluno(Aluno a){
        db = this.getWritableDatabase();
        String[] args = {String.valueOf(a.getAlunoId())};

        return db.delete(TABLE_ALUNO, "alunoId=?",args) > 0;
    }


}
