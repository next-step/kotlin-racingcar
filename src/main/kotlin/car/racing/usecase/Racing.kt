package car.racing.usecase

import car.racing.domain.Car

class Racing {

    fun race(cars: List<Car<*>>, turnCount: Int) {
        repeat(turnCount) {
            cars.forEach { car ->
                car.move()
            }
        }
    }
}
