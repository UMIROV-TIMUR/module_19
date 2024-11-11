package com.umirov.myapplication



import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.umirov.myapplication.databinding.ActivityDetailsBinding



class DetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setFilmsDetails()
    }

    private fun setFilmsDetails() {
        //Получаем наш фильм из переданного бандла
        val film = if (android.os.Build.VERSION.SDK_INT >= 33) { intent.getParcelableExtra("film", Film::class.java) } else { @Suppress("DEPRECATION") intent.getParcelableExtra("film") as? Film }
        if (film!= null) {
            //Устанавливаем заголовок
            binding.detailsToolbar.title = film.title
        }
        //Устанавливаем картинку
        if (film != null) {
            binding.detailsPoster.setImageResource(film.poster)
        }
        //Устанавливаем описание
        if (film != null) {
            binding.detailsDescription.text = film.description
        }
    }
}
