package racingcar.strategy

private const val MIN_NUMBER_TO_MOVE = 4
private const val MAX_NUMBER = 10

class CarMoveMoveStrategy : MoveStrategy {
    override fun canMove(): Boolean {
        val randomNumber = kotlin.random.Random.nextInt(MAX_NUMBER)
        return randomNumber >= MIN_NUMBER_TO_MOVE
    }
}
