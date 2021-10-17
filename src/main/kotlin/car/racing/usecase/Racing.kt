package car.racing.usecase

import car.racing.domain.Car

class Racing {

    fun race(cars: List<Car>, turnCount: Int) {
        (1..turnCount).forEach { turn ->
            cars.forEach { car ->
                val condition = (0 until 10).random()
                car.move(turn, condition)
            }
        }
    }
}
