package com.umirov.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.umirov.myapplication.databinding.FragmentDetailsBinding

class DetailsFragment : Fragment() {
    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setFilmsDetails()
    }

    private fun setFilmsDetails() {
        // Получаем наш фильм из переданного бандла
        val film = arguments?.getParcelable<Film>("film")

        // Проверяем, что film не равен null
        film?.let {
            // Устанавливаем заголовок
            binding.detailsToolbar.title = it.title
            // Устанавливаем картинку
            binding.detailsPoster.setImageResource(it.poster)
            // Устанавливаем описание
            binding.detailsDescription.text = it.description
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
