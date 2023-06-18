package racingCarMVC.domain

import racingCarMVC.domain.dto.GameResult
import racingCarMVC.domain.dto.GameRecord
import racingCarMVC.domain.dto.RacingResult

class RacingField(
    private val cars: List<Car>,
    private val _gameCount: Int,
) {
    val carNames: List<String>
        get() = cars.map { it.name }
    val gameCount: Int
        get() = _gameCount

    constructor(carNames: Array<String>, gameCount: Int) : this(List(carNames.size) { Car(carNames[it]) }, gameCount)

    fun startRacing(numberGenerator: NumberGenerator): RacingResult {
        val gameResults = List(gameCount) { this.playGame(numberGenerator) }
        return RacingResult(gameResults, RacingGameResult(gameResults.last().gameRecord).getWinners())
    }

    private fun playGame(numberGenerator: NumberGenerator): GameResult {
        return GameResult(
            cars.map {
                it.move(numberGenerator.getRandomNumber())
                GameRecord(it.name, it.position)
            }
        )
    }
}
