package racingcar.communication

import racingcar.communication.input.Input
import racingcar.communication.output.Output
import racingcar.domain.cars.RacingCar

object Pit {
    fun courseInRacingCarsNames(input: Input, output: Output): List<RacingCar> {
        output.numberOfCarsNames()
        val racingCarsNames = input.racingCarsNames().map { it.trim() }
        return racingCarsNames.map { RacingCar(name = it) }
    }
}
