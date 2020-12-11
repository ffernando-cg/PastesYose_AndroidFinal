package com.example.appfinalexamen.Controlador

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import com.example.appfinalexamen.R
import kotlinx.android.synthetic.main.activity_detalle_paste.*

class DetallePaste : AppCompatActivity() {

    var imagenPaste: Int = 0
    var nombrePaste: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_paste)

        setSupportActionBar(toolbar)

        if(supportActionBar != null){
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        }

        setStatusBarTranslucent(true)

        if(intent.extras != null){
            nombrePaste = intent.extras!!.getString("nombrePaste")!!
            imagenPaste = intent.extras!!.getInt("imagenPaste")
        }


        app_bar_image.setImageResource(imagenPaste)
        collapsingToolbar.title = nombrePaste
        window.setFlags(
            WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION,
            WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION
        )
    }

    private fun setStatusBarTranslucent(makeTranslucent:Boolean){
        if(makeTranslucent){
            window.statusBarColor = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
        }else{
            window.statusBarColor = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
        }
    }
}