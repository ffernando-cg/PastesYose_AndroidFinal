package com.example.appfinalexamen.Controlador

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.appfinalexamen.Entidades.Pastes
import com.example.appfinalexamen.Entidades.Pedidos
import com.example.appfinalexamen.Modelo.PastesDB
import com.example.appfinalexamen.R
import kotlinx.android.synthetic.main.fragment_paste_casa.*
import me.ibrahimsn.lib.SmoothBottomBar
import org.imaginativeworld.whynotimagecarousel.CarouselItem

class BottomBarFragmentController : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_bar_fragment_controller)

        bringInformationToMainPage()
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        var navController: NavController = findNavController(R.id.nav_host_fragment)
        val bottomBar:SmoothBottomBar = findViewById(R.id.bottomBar);
        menuInflater.inflate(R.menu.menu_nav,menu)
        bottomBar.setupWithNavController(menu!!,navController)
        return true
    }

    fun bringInformationToMainPage(){
        val list = mutableListOf<CarouselItem>()
        list.add(
                CarouselItem(
                        imageUrl = "https://cdn.kiwilimon.com/recetaimagen/37185/th5-640x426-46748.jpg",
                        caption = "Paste tradicional!"
                )
        )
        list.add(
                CarouselItem(
                        imageUrl = "https://mineroingles.com/wp-content/uploads/2019/09/20190901232940_IMG_3481.jpg",
                        caption = "Paste de mole poblano"
                )
        )
        list.add(
                CarouselItem(
                        imageUrl = "https://ceeccafetales.edu.mx/wp-content/uploads/2020/03/f5de33_ec175605853d4332ba66b3853d5e9e67.jpg",
                        caption = "Delicioso paste hawaiano"
                )
        )

//        carousel.addData(list)
        val datasource = PastesDB(this)
        val registros = ArrayList<Pastes>()
        val cursor = datasource.consultPastes()
        while (cursor.moveToNext()){
            val columnas = Pastes(cursor.getInt(0), cursor.getString(1) ,cursor.getString(2), cursor.getDouble(3), cursor.getString(4))
            registros.add(columnas)
        }

        val adaptador = PasteCasa.AdaptadorPastes(this, registros)
        try {
            lstPastes.adapter = adaptador
        }catch (ex:Exception){

        }
    }

    fun bringInformationToPastesDetail(){
        val datasource = PastesDB(this)
        val registros = ArrayList<Pedidos>()
        val cursor = datasource.consultPedidos()
        while (cursor.moveToNext()){
            val columnas = Pedidos(cursor.getInt(0), cursor.getInt(1) ,cursor.getInt(2), cursor.getInt(3))
            registros.add(columnas)
        }

        //TODO Arreglar el envio de datos a la pagina
        /*val adaptador = PasteCasa.AdaptadorPastes(this, registros)
        try {
            lstPastes.adapter = adaptador
        }catch (ex:Exception){

        }*/
    }
}