package aad.cafeteriagoya

import aad.cafeteriagoya.databinding.ActivityLaBinding
import aad.cafeteriagoya.fragments.CarritoFragment
import aad.cafeteriagoya.fragments.MenuFragment
import aad.cafeteriagoya.fragments.ViewModelProducto
import aad.cafeteriagoya.sqlite.MiBDOpenHelper
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.fragment.app.add
import androidx.fragment.app.commit

class laActivity : AppCompatActivity() {

    private lateinit var hora:String
    private lateinit var binding: ActivityLaBinding
    private val productViewModel: ViewModelProducto by viewModels()
    private var bd: MiBDOpenHelper? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        productViewModel.setContext(this)


    }

    fun mostrarCarrito(view: View)
    {
        val transaccion = supportFragmentManager.beginTransaction()
        val fragmento=CarritoFragment()

        transaccion.replace(R.id.fragmentContainerView, fragmento)
        transaccion.addToBackStack(null)
        binding.btnCarrito.isVisible=false
        binding.btnMenu.isVisible=true
        binding.pagar.isVisible=true

        transaccion.commit()
    }

    fun mostrarMenu(view: View)
    {
        val transaccion = supportFragmentManager.beginTransaction()
        val fragmento= MenuFragment()

        transaccion.replace(R.id.fragmentContainerView, fragmento)
        transaccion.addToBackStack(null)
        binding.btnCarrito.isVisible=true
        binding.btnMenu.isVisible=false
        binding.pagar.isVisible=false

        transaccion.commit()
    }

    fun insertar(view: View){
        var id=""
        var total: Double=0.0
        for(producto in productViewModel.productos){

            id= id+ producto.id+","
            total += producto.precio
        }
        bd?.andirPedido(id,total)

        intent = Intent(this, CarritoActivity::class.java)

        startActivity(intent)


    }


}