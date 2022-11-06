package nexstep.mission.racingcar

class RacingGame(val racingCars: List<RacingCar>) {
    constructor(count: Int) : this(createRacingCars(count))

    companion object {
        private tailrec fun createRacingCars(
            count: Int,
            racingCars: MutableList<RacingCar> = mutableListOf()
        ): List<RacingCar> =
            when (true) {
                (count == 0) -> racingCars.toList()
                else -> {
                    racingCars += RacingCar()
                    createRacingCars(count - 1, racingCars)
                }
            }
    }
}
