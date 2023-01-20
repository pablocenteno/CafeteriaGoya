package aad.cafeteriagoya

import aad.cafeteriagoya.sqlite.MiBDOpenHelper
import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Pedido : AppCompatActivity() {
    private var base: MiBDOpenHelper? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pedido)
        var id =intent.getIntExtra("id",0)
        var textView :TextView= findViewById(R.id.cosas)
        base= MiBDOpenHelper(this, null)
        var cursor: Cursor= base!!.obtenerUnPedido(id)

        cursor.moveToFirst()


        var con = cursor.getString(3)

        var content = con.split(",")

        content = content.subList(0,content.size-1)

        var p = ""

        for(c in content)
        {
            p = p + DataProvider.listaProductos.get(c.toInt())
        }


        textView.text=p
    }
}