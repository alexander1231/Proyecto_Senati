package com.example.alexander.projectx.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.alexander.projectx.modelo.Usuario;

public class SQLUsuario extends SQLConexion{
    private Context ct;

    public SQLUsuario(Context context){
        super(context);
        ct = context;
    }

    @Override
    public void  onCreate(SQLiteDatabase db){super.onCreate(db);}

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int il) { super.onUpgrade(db,i,il);}

    public void  getAdd(Usuario obj)throws SQLException{
        SQLiteDatabase sql = this.getWritableDatabase();

        ContentValues val = new ContentValues();


    }
}
