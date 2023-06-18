package racingCarMVC.domain

import racingCarMVC.domain.dto.GameResult
import racingCarMVC.domain.dto.Player

class RacingField(
    private val cars: List<Car>,
    private val _gameCount: Int,
) {
    val carNames: List<String>
        get() = cars.map { it.name }
    val gameCount: Int
        get() = _gameCount

    constructor(carNames: Array<String>, gameCount: Int) : this(List(carNames.size) { Car(carNames[it]) }, gameCount)

    fun startRacing(numberGenerator: NumberGenerator): List<GameResult> {
        return List(gameCount) { this.playGame(numberGenerator) }
    }

    private fun playGame(numberGenerator: NumberGenerator): GameResult {
        return GameResult(
            cars.map {
                it.move(numberGenerator.getRandomNumber())
                Player(it.name, it.position)
            }
        )
    }
}
