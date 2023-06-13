package racingcar.service

import racingcar.domain.Car
import racingcar.domain.CarName
import racingcar.domain.Cars
import racingcar.domain.condition.Condition

class RacingGameService {
    private val defaultPosition = 0
    private lateinit var cars: Cars

    fun initCars(inputCarNames: String, condition: Condition) {
        val carNames = inputCarNames.split(DELIMITER)
        cars = Cars(carNames.map { Car(defaultPosition, CarName(it), condition) })
    }

    fun play() {
        cars.move()
        cars.getPosition()
    }

    fun getWinners() = cars.getWinners()

    companion object {
        private const val DELIMITER = ","
    }
}
