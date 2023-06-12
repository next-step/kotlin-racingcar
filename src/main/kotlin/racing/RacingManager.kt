package racing

import racing.domain.Car

class RacingManager {

    fun getRaceWinnerCars(cars: List<Car>): List<Car> {
        val maxPosition = cars.maxOf { it.position }
        return cars.filter { it.position == maxPosition }
    }
}
