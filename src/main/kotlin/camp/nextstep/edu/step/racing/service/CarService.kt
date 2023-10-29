package camp.nextstep.edu.step.racing.service

import camp.nextstep.edu.step.racing.domain.Car
import camp.nextstep.edu.step.racing.strategy.CarMoveStrategy

class CarService(
    private val carMoveStrategy: CarMoveStrategy
) {
    fun createCarByInput(carName: String): Car {
        return Car(carName = carName)
    }

    fun carMoveByMoveStrategy(car: Car): Car {
        val carMoveStatus = carMoveStrategy.isMovable()
        car.moveForward(isMove = carMoveStatus)

        return car
    }

}
