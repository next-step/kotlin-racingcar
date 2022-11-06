package step3_racingcar.strategy

interface MovingStrategy {
    fun move(): Boolean
    fun getRandomNumber() = NUMBER_RANGE.random()

    companion object {
        private val NUMBER_RANGE = (0..9)
    }
}
