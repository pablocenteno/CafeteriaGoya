package aad.cafeteriagoya.adapterCarritoActivity

import aad.cafeteriagoya.R
import aad.cafeteriagoya.entidades.Producto
import android.content.Context
import android.database.Cursor
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class CarritoActAdaptador(private val onClickListener: (Int) -> Unit
): RecyclerView.Adapter<CarritoActViewHolder>()
{
    private lateinit var context: Context
    lateinit var productos: ArrayList<Producto>
    lateinit var cursor: Cursor

    fun CarritoAdaptador(context: Context, cursor: Cursor)
    {
        this.context = context
        this.cursor=cursor
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarritoActViewHolder
    {
        val layoutInflater = LayoutInflater.from(parent.context)

        return CarritoActViewHolder(layoutInflater.inflate(R.layout.item_carrito, parent, false))
    }

    //Renederizamos cada elemento de la lista
    override fun onBindViewHolder(holder: CarritoActViewHolder, position: Int)
    {
        cursor.moveToPosition(position)
        holder.render(cursor.getString(0),cursor.getString(1),onClickListener)
    }

    //Obtenemos el tamaño de la lista
    override fun getItemCount(): Int
    {
        return cursor.count
    }
}