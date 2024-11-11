package com.umirov.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.navigation.NavigationBarView
import com.umirov.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var filmsAdapter: FilmListRecyclerAdapter
    private lateinit var binding: ActivityMainBinding

    private val filmsDataBase = listOf(
        Film("Red One", R.drawable.red_one, "After Santa Claus (code name: Red One) is kidnapped, the North Pole's Head of Security (Dwayne Johnson) must team up with the world's most infamous bounty hunter (Chris Evans) in a globe-trotting, action-packed mission to save Christmas."),
        Film("Dune: Part Two", R.drawable.dune, "Paul Atreides unites with the Fremen while on a warpath of revenge against the conspirators who destroyed his family. Facing a choice between the love of his life and the fate of the universe, he endeavors to prevent a terrible future."),
        Film("Kingdom of the Planet of the Apes", R.drawable.kingdom_of_the_apes, "Many years after the reign of Caesar, a young ape goes on a journey that will lead him to question everything he's been taught about the past and make choices that will define a future for apes and humans alike."),
        Film("Bad Boys: Ride or Die", R.drawable.bad_boys, "When their late police captain gets linked to drug cartels, wisecracking Miami cops Mike Lowrey and Marcus Burnett embark on a dangerous mission to clear his name."),
        Film("Venom: The Last Dance", R.drawable.venom, "Eddie and Venom, on the run, face pursuit from both worlds. As circumstances tighten, they're compelled to make a heart-wrenching choice that could mark the end of their symbiotic partnership."),
        Film("Deadpool & Wolverine", R.drawable.deadpool_and_wolverine,"Deadpool is offered a place in the Marvel Cinematic Universe by the Time Variance Authority, but instead recruits a variant of Wolverine to save his universe from extinction."),
        Film("The Wild Robot", R.drawable.robot, "After a shipwreck, an intelligent robot called Roz is stranded on an uninhabited island. To survive the harsh environment, Roz bonds with the island's animals and cares for an orphaned baby goose.")
    )



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        enableEdgeToEdge()

        setupRecyclerView()
        setupAppBar()
        setupBottomNavigation()
        applyWindowInsets()
    }

    private fun setupRecyclerView() {
        binding.mainRecycler.apply {
            filmsAdapter = FilmListRecyclerAdapter(object : FilmListRecyclerAdapter.OnItemClickListener {
                override fun click(film: Film) {

                    val bundle = Bundle().apply {
                        putParcelable("film", film)
                    }
                    val intent = Intent(this@MainActivity, DetailsActivity::class.java).apply {
                        putExtras(bundle)
                    }
                    startActivity(intent)
                }




            })
            adapter = filmsAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
            addItemDecoration(TopSpacingItemDecoration(8))
        }
        // Кладем нашу БД в RV
        filmsAdapter.addItems(filmsDataBase)
    }

    private fun setupAppBar() {
        val topAppBar: Toolbar = binding.topAppBar

        topAppBar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.settings -> {
                    Toast.makeText(this, "Настройки", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }
    }

    private fun setupBottomNavigation() {
        val bottomNavigation: NavigationBarView = binding.bottomNavigation

        bottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.fav -> {
                    Toast.makeText(this, "Избранное", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.watchlater -> {
                    Toast.makeText(this, "Посмотреть позже", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.collections -> {
                    Toast.makeText(this, "Подборки", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }
    }

    private fun applyWindowInsets() {
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}





