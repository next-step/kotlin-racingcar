package study.racinggame.domain

class RacingGame(
    val cars: List<Car>,
    val numberOfTries: Int,
) {

    fun start(): List<RacingGameResult> {
        return (0 until numberOfTries)
            .map { stage ->
                val positionOfCars = cars.map { it.move() }
                RacingGameResult(stage, positionOfCars)
            }
    }
}
data class RacingGameResult(val stage: Int, val positionOfCars: List<Int>)
