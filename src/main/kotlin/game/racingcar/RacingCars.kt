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

    fun locationSnapshot(): List<Int> {
        return racingCars.map { it.location }
    }
}
