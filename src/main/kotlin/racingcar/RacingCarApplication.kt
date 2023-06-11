package racingcar

import racingcar.service.RacingCarService
import racingcar.view.InputView
import racingcar.view.OutputView

object RacingCarApplication {
    private val racingCarService = RacingCarService()
    private val inputView = InputView()
    private val outputView = OutputView()

    @JvmStatic
    fun main(args: Array<String>) {
        val namesOfCars = inputView.namesOfCars()
        val numberOfAttempts = inputView.numberOfAttempts()

        outputView.printResultMsg()
        val winners = racingCarService.play(namesOfCars, numberOfAttempts)
        outputView.printWinners(winners)
    }
}
