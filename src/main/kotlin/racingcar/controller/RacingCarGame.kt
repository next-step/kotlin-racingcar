package racingcar.controller

import racingcar.domain.Cars
import racingcar.domain.Race
import racingcar.domain.Scores
import racingcar.dto.GameCondition
import racingcar.strategy.NumberGeneratorStrategy

class RacingCarGame(
    private val gameCondition: GameCondition,
    private val strategy: NumberGeneratorStrategy,
) {
    fun startGame(): List<Scores> {
        val cars = Cars(gameCondition.carNames)
        val rounds = gameCondition.gameRound.number
        val allRoundScore = ArrayList<Scores>()
        repeat(rounds) {
            val race = Race(cars, strategy)
            val scores = race.raceOneRound()
            allRoundScore.add(scores)
        }
        return allRoundScore
    }
}
