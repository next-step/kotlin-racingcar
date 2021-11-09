package racingcar.domain

import racingcar.domain.cars.Cars
import racingcar.domain.cars.NumberOfCars
import racingcar.input.Input
import racingcar.output.Output

object Pit {
    fun courseInRacingCars(input: Input, output: Output): Cars {
        output.numberOfCarsMessage()
        val numberOfCars = input.numberOfCars()

        return Cars(numberOfCars = NumberOfCars(numberOfCars))
    }
}
