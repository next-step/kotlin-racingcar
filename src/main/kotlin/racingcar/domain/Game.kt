package racingcar.domain

import racingcar.domain.condition.NotMoveCondition
import racingcar.domain.condition.RandomMoveCondition
import racingcar.domain.strategy.SatisfySingleConditionMoveStrategy
import racingcar.dto.GameResult

class Game(
    private val carNames: List<String>,
    private val numberOfTry: Int,
) {
    private val gameResult = GameResult()

    fun execute(): GameResult {
        val cars = Cars(
            carNames = carNames,
            moveStrategy = SatisfySingleConditionMoveStrategy(listOf(RandomMoveCondition(), NotMoveCondition())),
        )

        repeat(numberOfTry) {
            cars.move()
            gameResult.addRecord(cars.getRecord())
        }
        return gameResult
    }
}
