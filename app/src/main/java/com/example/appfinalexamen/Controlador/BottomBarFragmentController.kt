package com.example.appfinalexamen.Controlador

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.appfinalexamen.Entidades.Pastes
import com.example.appfinalexamen.Modelo.ImageConverter
import com.example.appfinalexamen.Modelo.PastesDB
import com.example.appfinalexamen.R
import kotlinx.android.synthetic.main.fragment_paste_casa.*
import kotlinx.android.synthetic.main.item_lista.view.*
import me.ibrahimsn.lib.SmoothBottomBar


class BottomBarFragmentController : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_bar_fragment_controller)

        LlenarInformacion()

    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        var navController: NavController = findNavController(R.id.nav_host_fragment)
        val bottomBar: SmoothBottomBar = findViewById(R.id.bottomBar);
        menuInflater.inflate(R.menu.menu_nav,menu)
        bottomBar.setupWithNavController(menu!!,navController)
        return true
    }

    fun LlenarInformacion(){
        val datasource = PastesDB(this)

        val registros = ArrayList<Pastes>()

        val cursor = datasource.consultPastes()

        while (cursor.moveToNext()){
            val columnas = Pastes(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getDouble(3), cursor.getString(4))
            registros.add(columnas)
        }

        val adaptador = AdaptadorPersonas(this, registros)
        lstPastes.adapter = adaptador
    }

    internal class AdaptadorPersonas(context: Context, datos: List<Pastes>): ArrayAdapter<Pastes>(context, R.layout.item_paste_lista, datos)
    {
        private val imageConverter: ImageConverter = ImageConverter()
        var _datos: List<Pastes>
        init {
            _datos = datos
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
                var inflater = convertView ?: LayoutInflater.from(context).inflate(R.layout.item_paste_lista, parent, false)

                val Entidad = getItem(position)

                inflater.lblTitulo2.text = Entidad!!._NombrePaste
                inflater.lblSubTitulo2.text = Entidad!!._DescripcionPaste

                //inflater.profile_image.setImageBitmap(imageConverter.bitmap(Entidad!!._imgPersona))

                return inflater
        }
    }
}