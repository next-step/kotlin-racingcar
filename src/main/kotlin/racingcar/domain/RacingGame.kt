package racingcar.domain

class RacingGame(private val racingCars: List<RacingCar>) {

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
