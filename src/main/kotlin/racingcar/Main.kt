package racingcar

import racingcar.communication.ControlTower
import racingcar.communication.Pit
import racingcar.communication.input.Input
import racingcar.communication.input.InputConsole
import racingcar.communication.output.Output
import racingcar.communication.output.OutputConsole
import racingcar.domain.RacingGame
import racingcar.domain.cars.RacingCars
import racingcar.domain.engine.Engine

fun main() {
    val input: Input = InputConsole()
    val output: Output = OutputConsole()

    val racingCars = RacingCars(carsNames = Pit.submitToCourseInRacingCarsNames(input, output))
    val finalLab = ControlTower.decideRacingLabs(input, output)

    RacingGame(output).start(racingCars, finalLab, Engine::defaultCylinder)
}
