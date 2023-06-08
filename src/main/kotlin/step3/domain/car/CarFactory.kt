package step3.domain.car

import java.util.concurrent.atomic.AtomicInteger

object CarFactory {

    private const val DEFAULT_POSITION = 0

    fun createCar(name: String, position: Int = DEFAULT_POSITION): Car = Car(
        name = name,
        position = AtomicInteger(position),
    )

    fun createCars(
        carNames: List<String>,
        position: Int = DEFAULT_POSITION,
    ): List<Car> = carNames.map {
        createCar(position = position, name = it)
    }
}
