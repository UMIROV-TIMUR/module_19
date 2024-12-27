package com.umirov.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.umirov.myapplication.Film
import com.umirov.myapplication.databinding.FilmItemBinding

class FilmListRecyclerAdapter(private val clickListener: OnItemClickListener) : RecyclerView.Adapter<FilmListRecyclerAdapter.FilmViewHolder>() {
    private val items = mutableListOf<Film>()

    override fun getItemCount() = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        val binding = FilmItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FilmViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        val film = items[position]
        holder.bind(film)
        holder.itemView.setOnClickListener {
            clickListener.click(film)
        }
    }

    fun addItems(list: List<Film>) {
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
    }

    inner class FilmViewHolder(private val binding: FilmItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(film: Film) {
            binding.title.text = film.title
            binding.description.text = film.description
            binding.poster.setImageResource(film.poster)
        }
    }

    interface OnItemClickListener {
        fun click(film: Film)
    }
}
