package racingcar.domain.engine

class DefaultEngine : Engine {
    override fun cylinder(): Int = (START_RANGE..END_RANGE).random()

    companion object {
        private const val START_RANGE = 0
        private const val END_RANGE = 9
    }
}
