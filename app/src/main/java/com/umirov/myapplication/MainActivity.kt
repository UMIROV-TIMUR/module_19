package com.umirov.myapplication


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.umirov.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        initNavigation()

        supportFragmentManager.beginTransaction()
            .add(binding.fragmentPlaceholder.id, HomeFragment()).addToBackStack(null).commit()


    }

    fun launchDetailsFragment(film: Film) {
        //Создаем "посылку"
        val bundle = Bundle()
        //Кладем наш фильм в "посылку"
        bundle.putParcelable("film", film)
        //Кладем фрагмент с деталями в перменную
        val fragment = DetailsFragment()
        //Прикрепляем нашу "посылку" к фрагменту
        fragment.arguments = bundle

        //Запускаем фрагмент
        supportFragmentManager.beginTransaction().replace(binding.fragmentPlaceholder.id, fragment)
            .addToBackStack(null).commit()

    }


    private fun initNavigation() {


        binding.bottomNavigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.fav -> {
                    val tag = "favorites"
                    val fragment = checkFragmentExistence(tag)

                    changeFragment(fragment ?: FavoritesFragment(), tag)




                    true
                }

                R.id.watchlater -> {
                    val tag = "watchlater"
                    val fragment = checkFragmentExistence(tag)

                    changeFragment(fragment ?: WatchLaterFragment(), tag)
                    true
                }

                R.id.selections -> {
                    val tag = "selections"
                    val fragment = checkFragmentExistence(tag)

                    changeFragment(fragment ?: SelectionsFragment(), tag)
                    true
                }

                R.id.home -> {
                    val tag = "home"
                    val fragment = checkFragmentExistence(tag)
                    changeFragment(fragment ?: HomeFragment(), tag)

                    true
                }

                else -> false
            }
        }
    }


    private fun checkFragmentExistence(tag: String): Fragment? =
        supportFragmentManager.findFragmentByTag(tag)

    private fun changeFragment(fragment: Fragment, tag: String) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_placeholder, fragment, tag)
            .addToBackStack(null)
            .commit()
    }
}












