package racingcar.model

class Winner(private val racingGame: RacingGame) {

    fun find(): String {
        val farthestDistance = racingGame.getFarthestCarDistance()
        return racingGame.racingCars.filter { it.movingDistance == farthestDistance }.joinToString { it.name }
    }
}
