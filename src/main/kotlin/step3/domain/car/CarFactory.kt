package step3.domain.car

import java.util.concurrent.atomic.AtomicInteger

object CarFactory {

    private const val DEFAULT_POSITION = 0
    private const val ZERO = 0

    fun createCar(position: Int = DEFAULT_POSITION): Car = Car(
        position = AtomicInteger(position),
    )

    @OptIn(ExperimentalStdlibApi::class)
    fun createCars(
        count: Int,
        position: Int = DEFAULT_POSITION,
    ): List<Car> = ZERO.rangeUntil(other = count)
        .map { createCar(position = position) }
}
