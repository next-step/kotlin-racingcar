package racingcar

import racingcar.util.ControlTower
import racingcar.util.Pit
import racingcar.view.input.Input
import racingcar.view.input.InputConsole
import racingcar.view.output.Output
import racingcar.view.output.OutputConsole
import racingcar.controller.RacingGame
import racingcar.domain.cars.RacingCars
import racingcar.domain.engine.Engine

fun main() {
    val input: Input = InputConsole()
    val output: Output = OutputConsole()

    val racingCars = RacingCars(racingCarList = Pit.courseInRacingCars(input, output))
    val finalLab = ControlTower.decideRacingLabs(input, output)

    RacingGame(output).start(racingCars, finalLab, Engine::defaultCylinder)
}
