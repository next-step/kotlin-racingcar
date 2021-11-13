package racingcar

import racingcar.communication.ControlTower
import racingcar.communication.Pit
import racingcar.domain.RacingGame
import racingcar.domain.cars.Cars
import racingcar.communication.input.Input
import racingcar.communication.input.InputConsole
import racingcar.communication.output.Output
import racingcar.communication.output.OutputConsole

fun main() {
    val input: Input = InputConsole()
    val output: Output = OutputConsole()

    val racingCars = Cars(numberOfRacingCars = Pit.readyToCourseInRacingCars(input, output))
    val finalLab = ControlTower.decideRacingLabs(input, output)

    RacingGame(output).start(racingCars, finalLab)
}
