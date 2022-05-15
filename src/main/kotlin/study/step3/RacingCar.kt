package study.step3

import java.util.concurrent.atomic.AtomicInteger

class RacingCar(private val moving: Moving) {

    private val moved = AtomicInteger(0)

    fun move(): Int {
        if (moving.isMovable()) {
            moved.incrementAndGet()
        }

        return getMoved()
    }

    fun getMoved(): Int {
        return moved.get()
    }
}
