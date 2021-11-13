package racingcar.communication

import racingcar.domain.cars.NumberOfRacingCars
import racingcar.communication.input.Input
import racingcar.communication.output.Output

object Pit {
    fun readyToCourseInRacingCars(input: Input, output: Output): NumberOfRacingCars {
        output.numberOfCarsMessage()
        return NumberOfRacingCars(input.numberOfRacingCars())
    }
}
