package racingcar.model

class RandomValueMovingStrategy : MovingStrategy {

    override fun forwardMovable(number: Int): Boolean {
        return number >= FORWARD_NUM
    }

    companion object {
        private const val FORWARD_NUM = 4
        fun getRandomValue() = (1..9).random()
    }
}
