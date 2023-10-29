package racingcar.domain

interface GameRule {
    fun getMovingDirection(): MovingDirection
}

object RandomGameRule : GameRule {

    private const val MIN_RANDOM_NUMBER = 0
    private const val MAX_RANDOM_NUMBER = 9
    private const val MOVABLE_NUMBER = 4

    override fun getMovingDirection(): MovingDirection {
        val movable = (MIN_RANDOM_NUMBER..MAX_RANDOM_NUMBER).random() >= MOVABLE_NUMBER
        return if (movable) MovingDirection.FORWARD else MovingDirection.STOP
    }
}
