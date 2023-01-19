package aad.cafeteriagoya.adapterCarrito

import aad.cafeteriagoya.R
import aad.cafeteriagoya.adapter.ProductoViewHolder
import aad.cafeteriagoya.entidades.Producto
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class CarritoAdaptador( private val onClickListener: (Int) -> Unit
): RecyclerView.Adapter<CarritoViewHolder>()
{
    private lateinit var context: Context
    lateinit var productos: ArrayList<Producto>

    fun CarritoAdaptador(context: Context, productos: ArrayList<Producto>)
    {
        this.context = context
        this.productos = productos
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarritoViewHolder
    {
        val layoutInflater = LayoutInflater.from(parent.context)

        return CarritoViewHolder(layoutInflater.inflate(R.layout.item_carrito, parent, false))
    }

    //Renederizamos cada elemento de la lista
    override fun onBindViewHolder(holder: CarritoViewHolder, position: Int)
    {
        holder.render(productos[position], onClickListener)
    }

    //Obtenemos el tamaño de la lista
    override fun getItemCount(): Int
    {
        return productos.size
    }
}