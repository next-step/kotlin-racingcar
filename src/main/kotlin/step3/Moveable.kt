package step3

import java.util.concurrent.ThreadLocalRandom

interface Moveable {
    fun moving(): Boolean

    class Always : Moveable {
        override fun moving() = true
    }

    class Random : Moveable {
        private val intRandom = IntRandom.Smart(ThreadLocalRandom.current(), BOUND_MAX)

        override fun moving() = intRandom.next() >= MOVING_MIN

        companion object {
            const val BOUND_MAX = 10
            const val MOVING_MIN = 4
        }
    }
}
