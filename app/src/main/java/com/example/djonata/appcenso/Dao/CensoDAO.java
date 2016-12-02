package com.example.djonata.appcenso.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.djonata.appcenso.Modelo.Censo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Djonata on 25/11/2016.
 */

public class CensoDAO extends SQLiteOpenHelper{

    public CensoDAO(Context context){super(context,"Censo",null,1);}

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "Create TABLE Censo("+
                "id INTEGER PRIMARY KEY,"+
                "homens INTEGER,"+
                "mulheres INTEGER,"+
                "criancas INTEGER,"+
                "endereco TEXT,"+
                "enviado INTEGER,"+
                "excluido INTEGER,"+
                "alterado INTEGER,"+
                "ok INTEGER);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS Censo";
    }

    public void insere(Censo censo){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues dados = pegaDadosCenso(censo);

        db.insert("Censo",null,dados);
    }

    public void altera(Censo censo){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues dados = pegaDadosCenso(censo);

        String[] params = {String.valueOf(censo.getID())};
        db.update("Censo",dados,"id=?",params);
    }

    public List<Censo> buscaColeta(){
        String sql = "SELECT * FROM Censo";
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(sql,null);

        List<Censo> censos = new ArrayList<>();

        while(c.moveToNext()){
            Censo censo = new Censo();
            censo.setId(c.getInt(c.getColumnIndex("id")));
            censo.setMulheres(c.getInt(c.getColumnIndex("mulheres")));
            censo.setHomens(c.getInt(c.getColumnIndex("homens")));
            censo.setCriancas(c.getInt(c.getColumnIndex("criancas")));
            censo.setEndereco(c.getString(c.getColumnIndex("endereco")));

            censos.add(censo);
        }
        c.close();
        return censos;
    }

    public void deleta(Censo censo){
        SQLiteDatabase db = getWritableDatabase();
        String[] params = {String.valueOf(censo.getID())};
        db.delete("Censo","id=?",params);
    }

    private ContentValues pegaDadosCenso(Censo censo){
        ContentValues dados = new ContentValues();
        dados.put("homens",censo.getHomens());
        dados.put("mulheres",censo.getMulheres());
        dados.put("criancas",censo.getCriancas());
        dados.put("endereco",censo.getEndereco());

        return dados;
    }
}
