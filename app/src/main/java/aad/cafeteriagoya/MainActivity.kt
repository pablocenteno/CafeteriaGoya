package aad.cafeteriagoya

import aad.cafeteriagoya.databinding.ActivityMainBinding
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity()
{
    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        binding?.buttonMain?.setOnClickListener{
            guardarHora()
        }

        setContentView(binding!!.root)
    }


    fun guardarHora()
    {
        if(binding!!.tvTiempo.text.equals(""))
        {
            Toast.makeText(this, "Necesito una hora", Toast.LENGTH_SHORT).show()
        }
        else
        {
            intent = Intent(this, laActivity::class.java).apply {
                putExtra("hora", binding!!.tvTiempo.text.toString())
            }

            startActivity(intent)
        }
    }
}



