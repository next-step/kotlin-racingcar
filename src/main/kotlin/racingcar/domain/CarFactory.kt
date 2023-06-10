package racingcar.domain

import java.util.concurrent.atomic.AtomicLong

object CarFactory {
    private var uniqueId = AtomicLong(0)

    fun newCar(): Car = Car(uniqueId.addAndGet(1L))
}
