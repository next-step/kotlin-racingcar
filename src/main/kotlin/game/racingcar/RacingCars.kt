package game.racingcar

class RacingCars(
    numberOfCars: Int
) {
    private val racingCars = (1..numberOfCars).map { RacingCar() }

    fun moveAll() {
        racingCars.forEach { it.move() }
    }

    fun locations(): List<Int> {
        return racingCars.map { it.location }
    }
}
