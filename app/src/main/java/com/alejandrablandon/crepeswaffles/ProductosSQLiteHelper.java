package com.alejandrablandon.crepeswaffles;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class ProductosSQLiteHelper extends SQLiteOpenHelper {

    private String DATA_BASE_NAME= "ProductosBD";
    private int DATA_VERSION=1;

    String sqlCreate="CREATE TABLE Productos (" +
            "idProducto     INTEGER PRIMARY KEY AUTOINCREMENT," +
            "Producto       TEXT," +
            "Descripcion    TEXT," +
            "Precio         INTEGER)";


    public ProductosSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(sqlCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXITS Productos");
        db.execSQL(sqlCreate);
    }
}
