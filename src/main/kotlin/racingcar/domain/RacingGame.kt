package racingcar.domain

class RacingGame(private val racingCars: List<RacingCar>) {

    val movements get() = racingCars.map { it.movement }

    fun move() {
        racingCars.forEach { it.move() }
    }
}
