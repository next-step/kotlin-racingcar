package racingcar

import racingcar.condition.NotMoveCondition
import racingcar.condition.RandomMoveCondition
import racingcar.strategy.SatisfySingleConditionMoveStrategy

class Game(private val numberOfCars: Int, numberOfTry: Int) {
    private val rounds = (0 until numberOfTry)

    fun execute(): GameResult {
        val cars = Cars(
            carNumber = numberOfCars,
            moveStrategy = SatisfySingleConditionMoveStrategy(),
            moveConditions = listOf(RandomMoveCondition(), NotMoveCondition())
        )
        return GameResult(rounds.map { cars.move() })
    }
}
