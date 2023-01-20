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
    lateinit var cursor: Cursor

    fun CarritoActAdaptador(context: Context, cursor: Cursor)
    {
        this.context = context
        this.cursor=cursor
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarritoActViewHolder
    {
        val layoutInflater = LayoutInflater.from(parent.context)

        return CarritoActViewHolder(layoutInflater.inflate(R.layout.item_actcarrito, parent, false))
    }

    //Renederizamos cada elemento de la lista
    override fun onBindViewHolder(holder: CarritoActViewHolder, position: Int)
    {
        cursor.moveToPosition(position)
        holder.render(cursor.getInt(0),cursor.getLong(2),onClickListener)
    }

    //Obtenemos el tamaño de la lista
    override fun getItemCount(): Int
    {
        return cursor.count
    }
}