package com.example.appfinalexamen.Controlador

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.appfinalexamen.R
import org.imaginativeworld.whynotimagecarousel.CarouselItem
import org.imaginativeworld.whynotimagecarousel.ImageCarousel

class MainPagePastes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_page_pastes)
        val carousel: ImageCarousel = findViewById(R.id.carousel)

        val list = mutableListOf<CarouselItem>()

        list.add(
            CarouselItem(
                imageUrl = "https://images.unsplash.com/photo-1532581291347-9c39cf10a73c?w=1080",
                caption = "Un rico paste de arroz"
            )
        )
        list.add(
            CarouselItem(
                imageUrl = "https://images.unsplash.com/photo-1532581291347-9c39cf10a73c?w=1080",
                caption = "Subscribanse a mi twitch / Maverick2806"
            )
        )
        list.add(
            CarouselItem(
                imageUrl = "https://images.unsplash.com/photo-1532581291347-9c39cf10a73c?w=1080",
                caption = "Arriba la fiera master"
            )
        )

        carousel.addData(list)
    }
}