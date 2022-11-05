package game.racingcar

class RacingCars(
    numberOfCars: Int
) {
    private val racingCars = mutableListOf<RacingCar>()

    init {
        repeat(numberOfCars) {
            racingCars.add(RacingCar())
        }
    }

    fun moveAll() {
        racingCars.forEach { it.move() }
    }

    fun locations(): List<Int> {
        return racingCars.map { it.location }
    }
}
