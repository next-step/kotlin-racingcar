package camp.nextstep.edu.step.racing.service

import camp.nextstep.edu.step.racing.domain.Car
import camp.nextstep.edu.step.racing.strategy.CarMoveStrategy

class CarService(
    private val carMoveStrategy: CarMoveStrategy
) {
    fun createCarByInput(inputCarValue: String): Car {
        return Car(carName = inputCarValue)
    }

    fun carMoveByMoveStrategy(car: Car): Car {
        car.moveForward(carMoveStrategy = carMoveStrategy)
        return car
    }

}
