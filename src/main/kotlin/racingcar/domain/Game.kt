package racingcar.domain

import racingcar.domain.condition.NotMoveCondition
import racingcar.domain.condition.RandomMoveCondition
import racingcar.dto.GameResult
import racingcar.domain.strategy.SatisfySingleConditionMoveStrategy

class Game(private val carNames: List<String>, numberOfTry: Int) {
    private val rounds = (0 until numberOfTry)
    fun execute(): GameResult {
        val cars = Cars(
            carNames = carNames,
            moveStrategy = SatisfySingleConditionMoveStrategy(listOf(RandomMoveCondition(), NotMoveCondition())),
        )
        return GameResult(rounds.map { cars.move() })
    }
}
