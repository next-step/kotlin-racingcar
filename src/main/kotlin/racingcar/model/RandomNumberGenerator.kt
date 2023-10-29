package racingcar.model

class RandomNumberGenerator : NumberGenerator {
    override fun getNumber(): Int {
        return (START_RANGE..END_RANGE).random()
    }

    companion object {
        private const val START_RANGE = 0
        private const val END_RANGE = 9
    }
}
