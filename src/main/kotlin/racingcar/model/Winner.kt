package racingcar.model

class Winner(private val racingGame: RacingGame) {

    fun find(): List<String> {
        val farthestDistance = racingGame.getFarthestCarDistance()
        return racingGame.racingCars.filter { it.isEqualDistance(farthestDistance) }.map { it.name }
    }
}
