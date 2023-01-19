package aad.cafeteriagoya.adapterCarritoActivity

import aad.cafeteriagoya.R
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CarritoActViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
    var textViewProducto :TextView= itemView.findViewById(R.id.textoProducto)
    var textViewPrecio :TextView= itemView.findViewById(R.id.precioProducto)
    var button = itemView.findViewById<Button>(R.id.buttonBorrar)



    fun render(
        producto: String,
        onClickListener1: String,
        onClickListener: (Int) -> Unit
    )
    {
        textViewProducto.text = producto.nombre
        textViewPrecio.text = producto.precio.toString() + "€"

        button.setOnClickListener {
            onClickListener(producto.id)
        }
    }
}