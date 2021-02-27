package racingcar.model.strategy

private const val MIN_NUMBER_TO_MOVE = 4

class MoveStrategy : Strategy {
    override fun canMove(): Boolean {
        val randomNumber = kotlin.random.Random.nextInt(MIN_NUMBER_TO_MOVE)
        return randomNumber >= MIN_NUMBER_TO_MOVE
    }
}
