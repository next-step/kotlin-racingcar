package nexstep.mission.racingcar

import nexstep.mission.calculator.removeFirst

private const val NAME_SPLITTER = ","

class RacingGame(val racingCars: List<RacingCar>) {
    constructor(count: Int) : this(createRacingCars(count))
    constructor(names: String) : this(createRacingCars(names.split(NAME_SPLITTER)))

    fun race(strategy: () -> Int): List<RacingCar> =
        racingCars.onEach { it.move(strategy.invoke()) }

    companion object {
        private tailrec fun createRacingCars(
            count: Int,
            racingCars: MutableList<RacingCar> = mutableListOf()
        ): List<RacingCar> =
            when (true) {
                (count == 0) -> racingCars.toList()
                else -> {
                    racingCars += RacingCar("") // compile error 임시 대응
                    createRacingCars(count - 1, racingCars)
                }
            }

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
