package com.example.alexander.projectx.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Alexander on 17/03/2018.
 */

public class SQLConexion  extends SQLiteOpenHelper{
    private final static int DATA_VERSION =1;
    private final static String DATABASE_NAME="ControlDeAsistencia";

    protected final static String TABLE_NAME="[Seguridad].[Usuarios]";
    protected final static String COD_USU="COD_USU";
    protected final static String NOM_USU="NOM_USU";


    public SQLConexion (Context context){ super(context,DATABASE_NAME,null,DATA_VERSION);}

    @Override
    public void onCreate(SQLiteDatabase db){
        /*String CREATE_TABLE="";
        CREATE_TABLE="CREATE TABLE "+TABLE_NAME+" ("
                +COD_USU+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                +NOM_USU+" TEXT,"
                +APE_USU+" TEXT,"
                +DNI_USU+" INTEGER,"
                +SEXO_USU+" TEXT,"
                +TIPO_USU+" TEXT,"
                +USU_USU+" TEXT,"
                +PAS_USU+" TEXT,"
                +")";
        db.execSQL(CREATE_TABLE);*/
    }

    @Override
    public  void onUpgrade(SQLiteDatabase db, int i, int il){
        /*String DROP ="";
        DROP= "DROP TABLE IF EXITS "+TABLE_NAME;
        db.execSQL(DROP);
        onCreate(db);*/
    }




}
