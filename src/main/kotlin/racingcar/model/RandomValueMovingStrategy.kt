package racingcar.model

data class RandomValueMovingStrategy(val number: Int) : MovingStrategy {

    init {
        if (number < 0 || number > 9) {
            throw IllegalArgumentException("1과 9사이의 값만을 받아야 합니다.")
        }
    }

    override fun forwardMovable(): Boolean {
        return number >= FORWARD_NUM
    }

    companion object {
        private const val FORWARD_NUM = 4
    }
}
