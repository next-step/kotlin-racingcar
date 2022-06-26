package racingcar.domain

class RacingGame(private val racingCars: List<RacingCar>) {
    val names get() = racingCars.map { it.name }
    val movements get() = racingCars.map { it.movement }

    fun move() {
        racingCars.forEach { it.move() }
    }

    fun getWinners(): List<String> {
        val winningMovement = movements.reduce { acc, movement ->
            if (acc >= movement) acc else movement
        }
        return racingCars
            .filter { it.movement == winningMovement }
            .map { it.name }
    }
}
