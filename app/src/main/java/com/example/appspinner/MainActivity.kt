package com.example.appspinner
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import android.widget.ArrayAdapter


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinner = findViewById<Spinner>(R.id.spinner)
        val imageView = findViewById<ImageView>(R.id.imageView)
        val textViewTitle = findViewById<TextView>(R.id.textViewTitle)

        val categorias = resources.getStringArray(R.array.categorias_array)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, categorias)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                val categoriaSeleccionada = parent.getItemAtPosition(position).toString()

                // Aquí configura la imagen y el título basándote en la categoría seleccionada
                when (categoriaSeleccionada) {
                    "Universo 1" -> {
                        imageView.setImageResource(R.drawable.img1)
                        textViewTitle.text = "Universo 1"
                    }
                    "Universo 2" -> {
                        imageView.setImageResource(R.drawable.img2)
                        textViewTitle.text = "Universo 2"
                    }
                    "Universo 3" -> {
                        imageView.setImageResource(R.drawable.img3)
                        textViewTitle.text = "Universo 3"
                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Manejar caso donde no se selecciona nada
            }
        }
    }
}
