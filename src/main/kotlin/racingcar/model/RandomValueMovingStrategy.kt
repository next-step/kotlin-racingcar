package racingcar.model

class RandomValueMovingStrategy : MovingStrategy {

    override fun forwardMovable(): Boolean {
        return (1..9).random() >= FORWARD_NUM
    }

    companion object {
        private const val FORWARD_NUM = 4
        private const val MIN_BOUND = 0
        private const val MAX_BOUND = 10
    }
}
