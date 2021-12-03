package racingcar.communication

import racingcar.communication.input.Input
import racingcar.communication.output.Output
import racingcar.domain.cars.RacingCar

object Pit {
    fun courseInRacingCars(input: Input, output: Output): List<RacingCar> {
        output.numberOfCarsNames()
        return input.racingCarsNames()
            .asSequence()
            .map { it.trim() }
            .map { RacingCar(name = it) }
            .toList()
    }
}
