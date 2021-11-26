package racingcar.domain.engine

fun interface Engine {
    fun cylinder(): Int

    companion object {
        private const val START_RANGE = 0
        private const val END_RANGE = 9

        fun defaultCylinder(): Int = (START_RANGE..END_RANGE).random()
    }
}
