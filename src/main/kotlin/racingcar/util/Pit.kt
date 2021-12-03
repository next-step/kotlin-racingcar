package racingcar.util

import racingcar.view.input.Input
import racingcar.view.output.Output
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
