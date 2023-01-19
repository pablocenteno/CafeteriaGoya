package aad.cafeteriagoya.adapterCarrito

import aad.cafeteriagoya.R
import aad.cafeteriagoya.entidades.Producto
import aad.cafeteriagoya.fragments.ViewModelProducto
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.recyclerview.widget.RecyclerView

class CarritoViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
    var textViewProducto = itemView.findViewById<TextView>(R.id.textoProducto)
    var textViewPrecio = itemView.findViewById<TextView>(R.id.precioProducto)
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