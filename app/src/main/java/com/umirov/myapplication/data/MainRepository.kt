package com.umirov.myapplication.data

import com.umirov.myapplication.R
import com.umirov.myapplication.domain.Film

class MainRepository {
    val filmsDataBase = listOf(
        Film(
            "Red One",
            R.drawable.red_one,
            "After Santa Claus (code name: Red One) is kidnapped, the North Pole's Head of Security (Dwayne Johnson) must team up with the world's most infamous bounty hunter (Chris Evans) in a globe-trotting, action-packed mission to save Christmas.",
            7.7f
        ),
        Film(
            "Dune: Part Two",
            R.drawable.dune,
            "Paul Atreides unites with the Fremen while on a warpath of revenge against the conspirators who destroyed his family. Facing a choice between the love of his life and the fate of the universe, he endeavors to prevent a terrible future.",
            7.9f
        ),
        Film(
            "Kingdom of the Planet of the Apes",
            R.drawable.kingdom_of_the_apes,
            "Many years after the reign of Caesar, a young ape goes on a journey that will lead him to question everything he's been taught about the past and make choices that will define a future for apes and humans alike.",
            6.7f
        ),
        Film(
            "Bad Boys: Ride or Die",
            R.drawable.bad_boys,
            "When their late police captain gets linked to drug cartels, wisecracking Miami cops Mike Lowrey and Marcus Burnett embark on a dangerous mission to clear his name.",
            7.5f
        ),
        Film(
            "Venom: The Last Dance",
            R.drawable.venom,
            "Eddie and Venom, on the run, face pursuit from both worlds. As circumstances tighten, they're compelled to make a heart-wrenching choice that could mark the end of their symbiotic partnership.",
            8.5f
        ),
        Film(
            "Deadpool & Wolverine",
            R.drawable.deadpool_and_wolverine,
            "Deadpool is offered a place in the Marvel Cinematic Universe by the Time Variance Authority, but instead recruits a variant of Wolverine to save his universe from extinction.",
            8.6f
        ),
        Film(
            "The Wild Robot",
            R.drawable.robot,
            "After a shipwreck, an intelligent robot called Roz is stranded on an uninhabited island. To survive the harsh environment, Roz bonds with the island's animals and cares for an orphaned baby goose.",
            7.6f
        )
    )
}