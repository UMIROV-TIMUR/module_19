package com.umirov.myapplication
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.umirov.myapplication.databinding.FilmItemBinding

//В конструктор класс передается layout, который мы создали(film_item.xml)
class FilmViewHolder(private val binding: FilmItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(film: Film) {
        //Привязываем view из layout к переменным
        binding.title.text = film.title
            binding.poster.setImageResource(film.poster)
         binding.description.text = film.description
    }
}
