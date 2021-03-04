package racingcar

interface Moveable {
    fun moving(): Boolean

    class Always : Moveable {
        override fun moving() = true
    }

    class Random : Moveable {
        private val intRandom = IntRandom.Smart(0..9)

        override fun moving() = intRandom.next().moreThen(MOVING_MIN)

        companion object {
            private const val MOVING_MIN = 4
        }
    }
}

private fun Int.moreThen(min: Int) = this >= min
