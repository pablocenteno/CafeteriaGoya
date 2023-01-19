package aad.cafeteriagoya.fragments

import aad.cafeteriagoya.DataProvider
import aad.cafeteriagoya.R
import aad.cafeteriagoya.adapter.MenuAdaptador
import aad.cafeteriagoya.databinding.FragmentMenuBinding
import aad.cafeteriagoya.entidades.Producto
import aad.cafeteriagoya.sqlite.MiBDOpenHelper
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager


class MenuFragment : Fragment() {

    private lateinit var binding: FragmentMenuBinding
    var base: MiBDOpenHelper? = null
    var lista: ArrayList<Producto> = ArrayList(DataProvider.listaProductos)
    val precioVM: ViewModelProducto by activityViewModels()
    lateinit var  producto: Producto
    private lateinit var adapterProductos: MenuAdaptador
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var frag= FragmentMenuBinding.inflate(inflater, container, false)
        binding=frag
        rellenarSpinner()

        iniciarRecicler()
        binding?.btFiltrar?.setOnClickListener{
            filtrar()
        }
    return binding.root
    }

    fun rellenarSpinner()
    {
        val categorias = arrayOf("Todas", "pincho", "cafe", "refresco", "bocadillo")

        var adaptador: ArrayAdapter<String> =
            ArrayAdapter(precioVM.getContext(), android.R.layout.simple_spinner_item, categorias)
        binding!!.spinner.adapter = adaptador
    }


    fun iniciarRecicler()
    {
        val recyclerView = binding?.recyclerView
        recyclerView?.layoutManager = LinearLayoutManager(precioVM.getContext())

        adapterProductos = MenuAdaptador(
            onClickListener = { pos -> dameID(pos) }
        )

        adapterProductos.MenuAdaptador(precioVM.getContext(),  lista)

        recyclerView?.adapter = adapterProductos
    }


    fun filtrar()
    {
        val categoria = binding?.spinner?.selectedItem.toString()

        val lista = ArrayList<Producto>()

        if (categoria != "Todas")
        {
            for (p in DataProvider.listaProductos)
            {
                if (p.categoria == categoria)
                {
                    lista.add(p)
                }
            }
            adapterProductos.productos = ArrayList(lista)
        }
        else
        {
            adapterProductos.productos = ArrayList(DataProvider.listaProductos)
        }

        adapterProductos.notifyDataSetChanged()
    }

    fun dameID(pos: Int)
    {
        precioVM.productos.add(DataProvider.listaProductos[pos-1])

        //base?.andirProducto(DataProvider.listaProductos[pos-1])
    }




}