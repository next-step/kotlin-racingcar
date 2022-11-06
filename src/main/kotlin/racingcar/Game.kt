package racingcar

import racingcar.condition.RandomMoveCondition

class Game(private val numberOfCars: Int, numberOfTry: Int) {
    private val rounds = (0 until numberOfTry)

    fun execute(): GameResult {
        val cars = Cars(numberOfCars, listOf(RandomMoveCondition()))
        return GameResult(rounds.map { cars.move() })
    }
}
