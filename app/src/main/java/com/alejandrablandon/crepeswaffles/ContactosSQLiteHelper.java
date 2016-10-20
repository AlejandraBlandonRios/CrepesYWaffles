package com.alejandrablandon.crepeswaffles;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ContactosSQLiteHelper extends SQLiteOpenHelper {

    private String DATA_BASE_NAME= "AgendaBD";
    private int DATA_VERSION=1;

    String sqlCreate="CREATE TABLE Contactos (" +
            "id         INTEGER PRIMARY KEY AUTOINCREMENT," +
            "Nombre     TEXT," +
            "Telefono   TEXT," +
            "Correo     TEXT)";


    public ContactosSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqlCreate);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXITS Contactos");
        db.execSQL(sqlCreate);

    }
}

//http://es.androids.help/q22859