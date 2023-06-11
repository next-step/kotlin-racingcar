package racingcar

import racingcar.service.RacingCarService
import racingcar.view.InputConsoleView
import racingcar.view.OutputConsoleView

object RacingCarApplication {
    private val inputConsoleView = InputConsoleView()
    private val outputConsoleView = OutputConsoleView()
    private val racingCarService = RacingCarService(outputConsoleView)

    @JvmStatic
    fun main(args: Array<String>) {
        val namesOfCars = inputConsoleView.namesOfCars()
        val numberOfAttempts = inputConsoleView.numberOfAttempts()

        outputConsoleView.printResultMsg()
        val winners = racingCarService.play(namesOfCars, numberOfAttempts)
        outputConsoleView.printWinners(winners)
    }
}
