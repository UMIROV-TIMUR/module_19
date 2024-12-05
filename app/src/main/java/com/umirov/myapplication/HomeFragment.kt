package com.umirov.myapplication

import android.os.Bundle
import android.transition.Scene
import android.transition.TransitionManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.umirov.myapplication.databinding.FragmentHomeBinding
import com.umirov.myapplication.databinding.MergeHomeScreenContentBinding


class HomeFragment : Fragment() {

    private lateinit var mergeBinding: MergeHomeScreenContentBinding
    private lateinit var b: FragmentHomeBinding

    private lateinit var filmsAdapter: FilmListRecyclerAdapter


    private val filmsDataBase = listOf(
        Film(
            "Red One",
            R.drawable.red_one,
            "After Santa Claus (code name: Red One) is kidnapped, the North Pole's Head of Security (Dwayne Johnson) must team up with the world's most infamous bounty hunter (Chris Evans) in a globe-trotting, action-packed mission to save Christmas."
        ),
        Film(
            "Dune: Part Two",
            R.drawable.dune,
            "Paul Atreides unites with the Fremen while on a warpath of revenge against the conspirators who destroyed his family. Facing a choice between the love of his life and the fate of the universe, he endeavors to prevent a terrible future."
        ),
        Film(
            "Kingdom of the Planet of the Apes",
            R.drawable.kingdom_of_the_apes,
            "Many years after the reign of Caesar, a young ape goes on a journey that will lead him to question everything he's been taught about the past and make choices that will define a future for apes and humans alike."
        ),
        Film(
            "Bad Boys: Ride or Die",
            R.drawable.bad_boys,
            "When their late police captain gets linked to drug cartels, wisecracking Miami cops Mike Lowrey and Marcus Burnett embark on a dangerous mission to clear his name."
        ),
        Film(
            "Venom: The Last Dance",
            R.drawable.venom,
            "Eddie and Venom, on the run, face pursuit from both worlds. As circumstances tighten, they're compelled to make a heart-wrenching choice that could mark the end of their symbiotic partnership."
        ),
        Film(
            "Deadpool & Wolverine",
            R.drawable.deadpool_and_wolverine,
            "Deadpool is offered a place in the Marvel Cinematic Universe by the Time Variance Authority, but instead recruits a variant of Wolverine to save his universe from extinction."
        ),
        Film(
            "The Wild Robot",
            R.drawable.robot,
            "After a shipwreck, an intelligent robot called Roz is stranded on an uninhabited island. To survive the harsh environment, Roz bonds with the island's animals and cares for an orphaned baby goose."
        )
    )


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        b = FragmentHomeBinding.inflate(inflater, container, false)
        mergeBinding = MergeHomeScreenContentBinding.bind(b.root)
        return b.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val scene = Scene.getSceneForLayout(
            b.homeFragmentRoot,
            R.layout.merge_home_screen_content,
            requireContext()
        )
        TransitionManager.go(scene)




        mergeBinding.searchView.setOnClickListener {
            mergeBinding.searchView.isIconified = false

        }

        mergeBinding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText.isNullOrEmpty()) {
                    filmsAdapter.addItems(filmsDataBase)
                    return true
                }
                val result = filmsDataBase.filter {
                    it.title.contains(newText.toString(), ignoreCase = true)

                }
                filmsAdapter.addItems(result)
                return true

            }
        })



        mergeBinding.mainRecycler.apply {
            filmsAdapter =
                FilmListRecyclerAdapter(object : FilmListRecyclerAdapter.OnItemClickListener {
                    override fun click(film: Film) {

                        (requireActivity() as MainActivity).launchDetailsFragment(film)
                    }


                })
            this.adapter = filmsAdapter
            this.layoutManager = LinearLayoutManager(requireContext())
            this.addItemDecoration(TopSpacingItemDecoration(8))
        }
        // Кладем нашу БД в RV
        filmsAdapter.addItems(filmsDataBase)

    }

    override fun onDestroyView() {
        super.onDestroyView()


    }
}


