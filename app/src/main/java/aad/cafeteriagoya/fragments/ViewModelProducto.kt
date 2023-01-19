package aad.cafeteriagoya.fragments

import aad.cafeteriagoya.entidades.Producto
import aad.cafeteriagoya.sqlite.MiBDOpenHelper
import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModelProducto : ViewModel() {
    var productos: MutableList<Producto> = mutableListOf<Producto>()
    private var bd: MiBDOpenHelper? = null
    lateinit var contexto: Context



    fun setDatabase(base: MiBDOpenHelper) {
        bd = base
    }

    fun getDatabase(): MiBDOpenHelper {
        return bd!!
    }

    /*fun setProducto() {
        var carrito = bd!!.obtenerCarrito()

        carrito.moveToFirst()

        if (carrito.position == -1) {

            productos =
                productos + carrito.getString(0) + carrito.getString(1) + carrito.getString(2) + carrito.getString(3)

            while (carrito.moveToNext()) {
                productos =
                    productos + carrito.getString(0) + carrito.getString(1) + carrito.getString(2) + carrito.getString(3)
            }
        }

    }*/

    fun setContext(contexto: Context) {
        this.contexto = contexto
    }

    fun getContext(): Context {
        return contexto
    }


}