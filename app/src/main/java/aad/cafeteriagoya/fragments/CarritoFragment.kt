package aad.cafeteriagoya.fragments

import aad.cafeteriagoya.DataProvider
import aad.cafeteriagoya.MainActivity
import aad.cafeteriagoya.adapter.MenuAdaptador
import aad.cafeteriagoya.adapterCarrito.CarritoAdaptador
import aad.cafeteriagoya.databinding.FragmentCarritoBinding
import aad.cafeteriagoya.databinding.FragmentMenuBinding
import aad.cafeteriagoya.entidades.Producto
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager


class CarritoFragment : Fragment() {
    private lateinit var binding: FragmentCarritoBinding
    private lateinit var hora:String

    val precioVM: ViewModelProducto by activityViewModels()
    private lateinit var adapterCarrito: CarritoAdaptador
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var frag = FragmentCarritoBinding.inflate(inflater, container, false)
        binding = frag
        iniciarRecicler()
        return binding.root
    }

    fun iniciarRecicler()
    {
        val recyclerView = binding?.recycler
        recyclerView?.layoutManager = LinearLayoutManager(precioVM.getContext())

        adapterCarrito = CarritoAdaptador(
            onClickListener = { pos -> dameID(pos) }
        )

        adapterCarrito.CarritoAdaptador(precioVM.getContext(),
            precioVM.productos as ArrayList<Producto>
        )

        recyclerView?.adapter = adapterCarrito
    }

    fun dameID(pos: Int)
    {
        precioVM.productos.removeAt(pos)
        //precioVM.productos.add(DataProvider.listaProductos[pos-1])

        //base?.andirProducto(DataProvider.listaProductos[pos-1])
        iniciarRecicler()
    }

    fun insertar(){

    }


}