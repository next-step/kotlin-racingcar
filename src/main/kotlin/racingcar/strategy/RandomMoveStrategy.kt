package racingcar.strategy

import kotlin.random.Random.Default.nextInt

private const val MIN_NUMBER_TO_MOVE = 4
private const val MAX_NUMBER = 10

class RandomMoveStrategy : MoveStrategy {
    override fun canMove(): Boolean {
        val randomNumber = nextInt(MAX_NUMBER)
        return randomNumber >= MIN_NUMBER_TO_MOVE
    }
}
