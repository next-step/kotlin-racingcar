package racingWinner.race

import racingWinner.vo.Car

object Racing {
    fun prepareRacing(carsName: List<String>): List<Car> {
        return carsName.map { Car(it, 0) }
    }

    fun startRacing(cars: List<Car>, movable: () -> Boolean) {
        for (car in cars) {
            move(movable, car)
        }
    }

    private fun move(movable: () -> Boolean, car: Car) {
        if (movable()) {
            car.move()
        }
    }
}
