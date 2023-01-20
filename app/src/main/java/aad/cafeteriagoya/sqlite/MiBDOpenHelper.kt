package aad.cafeteriagoya.sqlite

import aad.cafeteriagoya.entidades.Producto
import android.content.ContentValues
import android.content.Context
import android.content.LocusId
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class MiBDOpenHelper(contex: Context, factory: SQLiteDatabase.CursorFactory?) :
    SQLiteOpenHelper(contex, DATABASE_NAME, factory, DATABASE_VERSION) {

    val TAG = "SQLite"

    companion object {
        val DATABASE_VERSION = 1
        val DATABASE_NAME = "pedidos.db"
        val T_PRODUCTOS = "pedidos"
        val PRODUCTO_INSERCION_ID = "id_compra"
        val PRODUCTO_ID = "fecha"
        val PRODUCTO_NOMBRE = "total"
        val PRODUCTO_PRECIO = "id_productos"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        var crearTablaPorductos = "CREATE TABLE $T_PRODUCTOS " +
                "($PRODUCTO_INSERCION_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "$PRODUCTO_ID DATETIME, " +
                "$PRODUCTO_NOMBRE LONG," +
                "$PRODUCTO_PRECIO TEXT)"
        var insercion_producto_prueba =
            "INSERT INTO $T_PRODUCTOS ($PRODUCTO_ID,$PRODUCTO_NOMBRE,$PRODUCTO_PRECIO) " +
                    "VALUES ('curdate()',234, '1,2,3');"
        db!!.execSQL(crearTablaPorductos)
        db!!.execSQL(insercion_producto_prueba)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        Log.e("$TAG (onUpgrade)", "Pendiente de realizar")
    }


    fun andirPedido( id: String, total:Double)
    {
        val db = this.writableDatabase
          val data = ContentValues()

            data.put(PRODUCTO_ID, "now")
            data.put(PRODUCTO_NOMBRE, total)
            data.put(PRODUCTO_PRECIO, id)
             db.insert(T_PRODUCTOS, null, data)
            db.close()
       /*var insercion_producto_prueba =
            "INSERT INTO $T_PRODUCTOS ($PRODUCTO_ID,$PRODUCTO_NOMBRE,$PRODUCTO_PRECIO) " +
                    "VALUES ('curdate()',total, 'id');"
        db!!.execSQL(insercion_producto_prueba)*/

    }

    fun obtenerCarrito(): Cursor
    {
        val db= this.readableDatabase
        var cursor = db.rawQuery("SELECT * FROM ${MiBDOpenHelper.T_PRODUCTOS} ", null)

        return cursor
    }
    fun obtenerUnPedido(id: Int): Cursor
    {
        val db= this.readableDatabase

        return db.rawQuery("SELECT * FROM ${MiBDOpenHelper.T_PRODUCTOS} where $PRODUCTO_INSERCION_ID='$id'", null)
    }

}