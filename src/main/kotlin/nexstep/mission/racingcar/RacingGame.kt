package nexstep.mission.racingcar

object RacingGame {

    tailrec fun createRacingCars(count: Int, racingCars: MutableList<RacingCar> = mutableListOf()): List<RacingCar> =
        when (true) {
            (count == 0) -> racingCars.toList()
            else -> {
                racingCars += RacingCar()
                createRacingCars(count - 1, racingCars)
            }
        }
}
