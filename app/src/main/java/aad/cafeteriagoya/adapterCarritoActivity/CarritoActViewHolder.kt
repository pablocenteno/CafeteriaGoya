package aad.cafeteriagoya.adapterCarritoActivity

import aad.cafeteriagoya.R
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CarritoActViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
    var textViewProducto :TextView= itemView.findViewById(R.id.idPedido)
    var textViewPrecio :TextView= itemView.findViewById(R.id.precioTotal)
    var button = itemView.findViewById<Button>(R.id.buttonBorrar)



    fun render(
        id_pedido: Int,
        total: Long,
        onClickListener: (Int) -> Unit
    )
    {
        textViewProducto.text = id_pedido.toString()
        textViewPrecio.text = total.toString() + "€"

        button.setOnClickListener {
            onClickListener(id_pedido)
        }
    }
}