package nexstep.mission.racingcar

import nexstep.mission.calculator.removeFirst

fun <T> MutableList<T>.pop() = this.removeFirst()
fun List<RacingCar>.toSortedMutable() = this.sortedByDescending { it.position }.toMutableList()

private const val NAME_SPLITTER = ","

class RacingGame(val racingCars: List<RacingCar>) {
    constructor(names: String) : this(createRacingCars(names.split(NAME_SPLITTER)))

    fun race(strategy: () -> Int): List<RacingCar> =
        racingCars.onEach { it.move(strategy.invoke()) }

    fun winner(favorites: MutableList<RacingCar> = this.racingCars.toSortedMutable()): List<RacingCar> =
        generateSequence(favorites.pop()) { next(it, favorites) }.toList()

    private fun next(previous: RacingCar, favorites: MutableList<RacingCar>) =
        when (previous.position) {
            favorites.first().position -> favorites.pop()
            else -> null
        }

    companion object {
        private tailrec fun createRacingCars(
            names: List<String>,
            racingCars: MutableList<RacingCar> = mutableListOf()
        ): List<RacingCar> =
            when (true) {
                names.isEmpty() -> racingCars.toList()
                else -> {
                    racingCars += RacingCar(names.first())
                    createRacingCars(names.removeFirst(), racingCars)
                }
            }
    }
}
