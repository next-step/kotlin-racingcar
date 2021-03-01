package racing

import racing.domain.Car
import racing.domain.Movable
import racing.domain.Racing

internal class RacingFactory {
    fun createRacing(numberOfCar: Int, movable: Movable): Racing {
        val cars = (1..numberOfCar).map { Car() }
        return Racing(cars, movable)
    }
}
