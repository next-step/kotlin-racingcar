package racingcar.domain

import racingcar.domain.condition.NotMoveCondition
import racingcar.domain.condition.RandomMoveCondition
import racingcar.domain.strategy.SatisfySingleConditionMoveStrategy
import racingcar.dto.GameResult
import racingcar.dto.Record

class Game(private val carNames: List<String>, private val numberOfTry: Int) {
    private val rounds = (0 until numberOfTry)
    fun execute(): GameResult {
        val cars = Cars(
            carNames = carNames,
            moveStrategy = SatisfySingleConditionMoveStrategy(listOf(RandomMoveCondition(), NotMoveCondition())),
        )
        val records = rounds.map { Record(cars.move()) }
        return GameResult(records)
    }
}
