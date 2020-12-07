package com.example.appfinalexamen.Controlador

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.appfinalexamen.Modelo.PastesDB
import com.example.appfinalexamen.R
import com.example.appfinalexamen.register_user
import java.util.logging.Handler


var user = "";
var contra = "";

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        user = txtCorreo.text.toString()
        contra = txtPassword.text.toString()


        btnEntrar.setOnClickListener {
            Handler().postDelayed(Runnable {

                val datasource = PastesDB(this)
                val cursor = datasource.consultarLogin(txtCorreo.text.toString(), txtPassword.text.toString())

                if (cursor.moveToFirst()) {
                    cursor.getInt(0)
                    var intent = Intent(this, MainPagePastes::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Credenciales incorrectas",Toast.LENGTH_SHORT).show()
                }
            }, 500)
        }

        btnRegistro.setOnClickListener{
            var intent = Intent(this, register_user::class.java)
            startActivity(intent)
        }
    }
}