package com.example.appfinalexamen.Controlador

import android.content.Context
import android.database.CursorWindow
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import com.example.appfinalexamen.Controlador.BottomBarFragmentController
import com.example.appfinalexamen.Entidades.Pastes
import com.example.appfinalexamen.Modelo.ImageConverter
import com.example.appfinalexamen.Modelo.PastesDB
import com.example.appfinalexamen.R
import kotlinx.android.synthetic.main.fragment_paste_casa.*
import org.imaginativeworld.whynotimagecarousel.CarouselItem
import org.imaginativeworld.whynotimagecarousel.ImageCarousel
import java.lang.reflect.Field


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [PasteCasa.newInstance] factory method to
 * create an instance of this fragment.
 */
class PasteCasa : Fragment() {
    // TODO: Rename and change types of parameters


    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        try {
            val field: Field = CursorWindow::class.java.getDeclaredField("sCursorWindowSize")
            field.isAccessible = true
            field.set(null, 100 * 1024 * 1024)
        } catch (e: Exception) {
            e.printStackTrace()
        }



    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_paste_casa, container, false)

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment PasteCasa.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            PasteCasa().apply {

            }
    }

    fun AgregarPastes(view: View) {

    }

    internal class AdaptadorPastes(context: Context, datos: List<Pastes>): ArrayAdapter<Pastes>(context, R.layout.item_paste_lista, datos){
        var _datos: List<Pastes>

        init{
            _datos = datos
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            val inflater = convertView ?: LayoutInflater.from(context).inflate(
                    R.layout.item_paste_lista, parent, false)

            val Entidad = getItem(position)

            inflater.findViewById<ImageView>(R.id.imgPaste).setImageBitmap(ImageConverter().bitmap(Entidad!!._img))

            return inflater
        }
    }
}