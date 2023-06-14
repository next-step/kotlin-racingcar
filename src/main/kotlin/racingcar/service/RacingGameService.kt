package racingcar.service

import racingcar.domain.Car
import racingcar.domain.CarName
import racingcar.domain.Cars
import racingcar.domain.condition.Condition

class RacingGameService {
    private val defaultPosition = 0
    private lateinit var cars: Cars

    fun initCars(inputCarNames: List<String>, condition: Condition) {
        cars = Cars(inputCarNames.map { Car(defaultPosition, CarName(it), condition) })
    }

    fun play(): Cars {
        cars.move()
        return cars
    }

    fun getWinners() = cars.getWinners()
}
