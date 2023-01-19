package aad.cafeteriagoya.adapterCarrito

import aad.cafeteriagoya.R
import aad.cafeteriagoya.entidades.Producto
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CarritoViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
    var textViewProducto = itemView.findViewById<TextView>(R.id.idPedido)
    var textViewPrecio = itemView.findViewById<TextView>(R.id.precioTotal)
    var button = itemView.findViewById<Button>(R.id.buttonBorrar)



    fun render(producto: Producto,
               onClickListener: (Int) -> Unit)
    {
        textViewProducto.text = producto.nombre
        textViewPrecio.text = producto.precio.toString() + "€"

        button.setOnClickListener {
            onClickListener(producto.id)
        }
    }
}