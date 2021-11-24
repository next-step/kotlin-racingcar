package racingcar.communication

import racingcar.communication.input.Input
import racingcar.communication.output.Output

object Pit {
    fun submitToCourseInRacingCarsNames(input: Input, output: Output): List<String> {
        output.numberOfCarsNames()
        return input.racingCarsNames().map { it.trim() }
    }
}
