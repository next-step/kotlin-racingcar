package racingcar.service

import racingcar.domain.Cars
import racingcar.view.numberOfAttempts
import racingcar.view.numberOfCar
import racingcar.view.printResult

class RacingCarService {
    fun play() {
        val numberOfCars = numberOfCar()
        val cars = Cars(numberOfCars)
        val numberOfAttempts = numberOfAttempts()

        printResult(cars, numberOfAttempts)
    }
}
