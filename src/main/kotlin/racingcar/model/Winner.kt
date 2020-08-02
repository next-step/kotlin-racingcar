package racingcar.model

class Winner(private val racingGame: RacingGame) {

    fun find(): String {
        val farthestDistance = getFarthestCarDistance()
        return racingGame.racingCars.filter { it.movingDistance == farthestDistance }.joinToString { it.name }
    }

    private fun getFarthestCarDistance() =
        racingGame.racingCars.maxBy { it.movingDistance }?.movingDistance ?: 0
}
