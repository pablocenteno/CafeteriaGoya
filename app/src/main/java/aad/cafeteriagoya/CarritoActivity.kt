package aad.cafeteriagoya

import aad.cafeteriagoya.adapter.MenuAdaptador
import aad.cafeteriagoya.adapterCarritoActivity.CarritoActAdaptador
import aad.cafeteriagoya.databinding.ActivityCarritoBinding
import aad.cafeteriagoya.databinding.ActivityMenuBinding
import aad.cafeteriagoya.sqlite.MiBDOpenHelper
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager

class CarritoActivity : AppCompatActivity()
{
    private var binding: ActivityCarritoBinding? = null
    private lateinit var hora:String
    private lateinit var adapterProductos2: CarritoActAdaptador
    private lateinit var base: MiBDOpenHelper
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityCarritoBinding.inflate(layoutInflater)

        hora = intent.getStringExtra("hora").toString()
        iniciarRecycler()
        //mostrarCarrito()

        binding?.btInicio?.setOnClickListener{
            volverCasa()
        }
        base = MiBDOpenHelper(this,null)

        setContentView(binding!!.root)
    }


   /* fun mostrarCarrito()
    {
        var base = MiBDOpenHelper(this, null)

        var cursor = base.obtenerCarrito()

        cursor.moveToFirst()

        var con = ""

        while(!cursor.isAfterLast)
        {
            con = con + "\n" + cursor.getString(2) + "-" + cursor.getString(3) + "€"

            cursor.moveToNext()
        }

    }*/


    fun volverCasa()
    {
        intent = Intent(this, MainActivity::class.java)

        startActivity(intent)
    }

    fun iniciarRecycler(){
        var base = MiBDOpenHelper(this, null)
        val cursor = base.obtenerCarrito()
        val recyclerView = binding?.reyclo
        recyclerView?.layoutManager = LinearLayoutManager(this)

        adapterProductos2 = CarritoActAdaptador (
            onClickListener = { pos -> dameID(pos) }
        )

        adapterProductos2.CarritoActAdaptador(this, cursor)

        recyclerView?.adapter = adapterProductos2
    }


    fun dameID(pos  : Int){
        intent = Intent(this, Pedido::class.java).apply {
            putExtra("id", pos)
        }

        startActivity(intent)
    }
}