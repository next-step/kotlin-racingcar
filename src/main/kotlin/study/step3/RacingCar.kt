package study.step3

import java.util.concurrent.atomic.AtomicInteger

class RacingCar {

    private val moved = AtomicInteger(0)

    fun go(): Int {
        return moved.incrementAndGet()
    }

    fun goTimes(numOfTry: Int): Int {
        repeat(numOfTry) { go() }

        return getMoved()
    }

    fun getMoved(): Int {
        return moved.get()
    }
}
